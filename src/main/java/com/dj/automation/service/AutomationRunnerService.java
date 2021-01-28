package com.dj.automation.service;

import com.dj.automation.model.RequestModel;

import java.io.IOException;
import java.net.MalformedURLException;

public interface AutomationRunnerService {
    public void runTests(RequestModel requestModel) throws IOException, ClassNotFoundException;
}
