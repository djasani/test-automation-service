package com.dj.automation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class ResponseModel implements Serializable {

    private static final long serialVersionUID = -7311073725249941357L;
    private String errorMessages;
    private Integer numberOfFailedTests;
    private Integer numberOfPassedTests;
    private Integer numberOfTests;
    private String reportDir;
    private Long executionTime;
    private String runId;
    private String status;
}
