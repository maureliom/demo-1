package com.example.demo.dto.ocpp.schema.set_variable_monitoring_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class SetVariableMonitoringResponse {


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("setMonitoringResult")
    private List<SetMonitoringResult> setMonitoringResult;

    @JsonProperty("setMonitoringResult")
    private List<SetMonitoringResult> setMonitoringResult = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
