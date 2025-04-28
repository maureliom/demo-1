package com.example.demo.dto.ocpp.schema.notify_monitoring_report_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class MonitoringData {


    @JsonProperty("component")
    private Component component;


    @JsonProperty("variable")
    private Variable variable;


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("variableMonitoring")
    private List<VariableMonitoring> variableMonitoring;

    @JsonProperty("variableMonitoring")
    private List<VariableMonitoring> variableMonitoring = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
