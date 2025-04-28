package com.example.demo.dto.ocpp.schema.report_dercontrol_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class DERCurve {


    @ElementCollection
    @Size(min = 1)
    @Size(max = 10)
    @JsonProperty("curveData")
    private List<DERCurvePoints> curveData;

    @JsonProperty("curveData")
    private List<DERCurvePoints> curveData = new ArrayList<>();


    @JsonProperty("hysteresis")
    private Hysteresis hysteresis;


    @Min(0)
    /** Priority of curve (0=highest) */
    @JsonProperty("priority")
    private Integer priority;

    @Min(0.0)

    @JsonProperty("reactivePowerParams")
    private ReactivePowerParams reactivePowerParams;


    @JsonProperty("voltageParams")
    private VoltageParams voltageParams;


    @JsonProperty("yUnit")
    private DERUnitEnum yUnit;


    /** Open loop response time, the time to ramp up to 90% of the new target in response to the change in voltage, in seconds. A value of 0 is used to mean no limit. When not present, the device should follow its default behavior. */
    @JsonProperty("responseTime")
    private Double responseTime;


    /** Point in time when this curve will become activated. Only absent when _default_ is true. */
    @JsonProperty("startTime")
    private String startTime;


    /** Duration in seconds that this curve will be active. Only absent when _default_ is true. */
    @JsonProperty("duration")
    private Double duration;


    @JsonProperty("customData")
    private CustomData customData;

}
