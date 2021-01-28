package com.dj.automation.entity;

public class AutomationEntity {

    private static final long serialVersionUID = 1L;

    private String automationTestRunId;
    private String automationTestRunName;
    private String executionStatus = "AUTOMATION_EXECUTION_REQUEST";
    private String errorMessages;
    private Integer numberOfFailedTests;
    private Integer numberOfPassedTests;
    private Integer numberOfTests;
    private Long executionTime;

    public String getAutomationTestRunId(){
        return  automationTestRunId;
    }

    public void setAutomationTestRunId(String automationTestRunId){
        this.automationTestRunId = automationTestRunId;
    }

    public String getAutomationTestRunName() {
        return automationTestRunName;
    }

    public void setAutomationTestRunName(String automationTestRunName) {
        this.automationTestRunName = automationTestRunName;
    }
}
