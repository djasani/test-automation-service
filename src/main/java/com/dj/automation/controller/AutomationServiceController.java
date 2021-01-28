package com.dj.automation.controller;

import com.dj.automation.model.RequestModel;
import com.dj.automation.service.AutomationRunIdService;
import com.dj.automation.service.AutomationRunnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.MalformedURLException;

@RestController
public class AutomationServiceController {
    private Logger LOGGER = LoggerFactory.getLogger(AutomationServiceController.class);

    @Autowired
    AutomationRunnerService automationRunnerService;

    @Autowired
    AutomationRunIdService automationRunIdService;

    @GetMapping("/health")
    public String getHealthCheck(){
        return "OK" + automationRunnerService;
    }

    @PostMapping(path="/runIntegrationTests")
    public String runIntegrationTests() throws IOException, ClassNotFoundException {
        String runId = automationRunIdService.createRunId("IntegrationTest");
        LOGGER.info("Run ID : " + runId);
        RequestModel rm = new RequestModel(0,runId);
        automationRunnerService.runTests(rm);
        return runId;
    }

}
