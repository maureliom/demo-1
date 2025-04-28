package com.example.demo.dto.ocpp.schema.set_dercontrol_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class FixedVar {


    @Min(0)
    /** Priority of setting (0=highest) */
    @JsonProperty("priority")
    private Integer priority;

    @Min(0.0)

    /** The value specifies a target var output interpreted as a signed percentage (-100 to 100). A negative value refers to charging, whereas a positive one refers to discharging. The value type is determined by the unit field. */
    @JsonProperty("setpoint")
    private Double setpoint;


    @JsonProperty("unit")
    private DERUnitEnum unit;


    /** Time when this setting becomes active. */
    @JsonProperty("startTime")
    private String startTime;


    /** Duration in seconds that this setting is active. */
    @JsonProperty("duration")
    private Double duration;


    @JsonProperty("customData")
    private CustomData customData;

}
