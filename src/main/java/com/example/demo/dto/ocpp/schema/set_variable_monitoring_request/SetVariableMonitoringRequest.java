package com.example.demo.dto.ocpp.schema.set_variable_monitoring_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class SetVariableMonitoringRequest {


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("setMonitoringData")
    private List<SetMonitoringData> setMonitoringData;

    @JsonProperty("setMonitoringData")
    private List<SetMonitoringData> setMonitoringData = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
