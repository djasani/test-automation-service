package com.dj.automation.service;

import com.dj.automation.entity.AutomationEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AutomationRunIdServiceImpl implements AutomationRunIdService {

    public String createRunId(String automationTestRunName){
        String runId = UUID.randomUUID().toString();
        AutomationEntity entity = new AutomationEntity();
        entity.setAutomationTestRunId(runId);
        entity.setAutomationTestRunName(automationTestRunName);
        return runId;
    }
}
