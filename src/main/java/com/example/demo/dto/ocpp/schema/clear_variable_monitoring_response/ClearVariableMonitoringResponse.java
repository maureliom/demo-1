package com.example.demo.dto.ocpp.schema.clear_variable_monitoring_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ClearVariableMonitoringResponse {


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("clearMonitoringResult")
    private List<ClearMonitoringResult> clearMonitoringResult;

    @JsonProperty("clearMonitoringResult")
    private List<ClearMonitoringResult> clearMonitoringResult = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
