package com.example.demo.dto.ocpp.schema.clear_variable_monitoring_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ClearVariableMonitoringRequest {


    @ElementCollection
    @Size(min = 1)
    /** List of the monitors to be cleared, identified by there Id. */
    @JsonProperty("id")
    private List<Integer> id;

    @JsonProperty("id")
    private List<Integer> id = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
