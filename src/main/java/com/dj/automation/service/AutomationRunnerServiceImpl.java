package com.dj.automation.service;

import com.dj.automation.model.RequestModel;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

@Service
@EnableAsync
public class AutomationRunnerServiceImpl implements AutomationRunnerService {

    @Async
    public void runTests(RequestModel requestModel) throws IOException, ClassNotFoundException {

        String testClassPath = System.getProperty("user.dir") + "/build/classes/java/test";
        Files.walk(Paths.get(testClassPath))
                .filter(Files::isRegularFile)
                .forEach(System.out::println);

        Class<?> clazz =new URLClassLoader(
                new URL[]{new File(testClassPath).toURI().toURL()}
        ).loadClass("com.dj.automation.CalculatorTest");

        LauncherDiscoveryRequest request =  LauncherDiscoveryRequestBuilder.request()
                .selectors(
                        selectClass(clazz)
                )
                .build();

        Launcher launcher = LauncherFactory.create();


        // Register a listener
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(listener);

        //TestPlan testPlan = launcher.discover(request);

        launcher.execute(request);

        TestExecutionSummary summary = listener.getSummary();
    }
}
