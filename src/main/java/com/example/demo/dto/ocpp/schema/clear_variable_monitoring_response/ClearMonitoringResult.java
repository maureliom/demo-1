package com.example.demo.dto.ocpp.schema.clear_variable_monitoring_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ClearMonitoringResult {


    @JsonProperty("status")
    private ClearMonitoringStatusEnum status;


    @Min(0)
    /** Id of the monitor of which a clear was requested. */
    @JsonProperty("id")
    private Integer id;

    @Min(0.0)

    @JsonProperty("statusInfo")
    private StatusInfo statusInfo;


    @JsonProperty("customData")
    private CustomData customData;

}
