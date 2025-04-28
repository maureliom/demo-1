package com.example.demo.dto.ocpp.schema.get_monitoring_report_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetMonitoringReportRequest {


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("componentVariable")
    private List<ComponentVariable> componentVariable;

    @JsonProperty("componentVariable")
    private List<ComponentVariable> componentVariable = new ArrayList<>();


    /** The Id of the request. */
    @JsonProperty("requestId")
    private Integer requestId;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 3)
    /** This field contains criteria for components for which a monitoring report is requested */
    @JsonProperty("monitoringCriteria")
    private List<MonitoringCriterionEnum> monitoringCriteria;

    @JsonProperty("monitoringCriteria")
    private List<MonitoringCriterionEnum> monitoringCriteria = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
