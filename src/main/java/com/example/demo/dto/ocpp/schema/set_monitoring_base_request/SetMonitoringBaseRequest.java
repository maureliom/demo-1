package com.example.demo.dto.ocpp.schema.set_monitoring_base_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class SetMonitoringBaseRequest {


    @JsonProperty("monitoringBase")
    private MonitoringBaseEnum monitoringBase;


    @JsonProperty("customData")
    private CustomData customData;

}
