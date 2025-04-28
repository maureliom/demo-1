package com.example.demo.dto.ocpp.schema.report_dercontrol_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class LimitMaxDischarge {


    @Min(0)
    /** Priority of setting (0=highest) */
    @JsonProperty("priority")
    private Integer priority;

    @Min(0.0)

    /** Only for PowerMonitoring. + The value specifies a percentage (0 to 100) of the rated maximum discharge power of EV. The PowerMonitoring curve becomes active when power exceeds this percentage. */
    @JsonProperty("pctMaxDischargePower")
    private Double pctMaxDischargePower;


    @JsonProperty("powerMonitoringMustTrip")
    private DERCurve powerMonitoringMustTrip;


    /** Time when this setting becomes active */
    @JsonProperty("startTime")
    private String startTime;


    /** Duration in seconds that this setting is active */
    @JsonProperty("duration")
    private Double duration;


    @JsonProperty("customData")
    private CustomData customData;

}
