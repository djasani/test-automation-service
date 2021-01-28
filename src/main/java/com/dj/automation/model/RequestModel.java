package com.dj.automation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


public class RequestModel implements Serializable {
    public RequestModel() {
        super();
    }

    public RequestModel(int threadCount, String runId){
        this.threadCount = threadCount;
        this.runId = runId;
    }

    private static final long serialVersionUID = -3240455901936234951L;

    private int threadCount;

    private String runId;

}
