package com.example.demo.dto.ocpp.schema.set_dercontrol_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class EnterService {


    @Min(0)
    /** Priority of setting (0=highest) */
    @JsonProperty("priority")
    private Integer priority;

    @Min(0.0)

    /** Enter service voltage high */
    @JsonProperty("highVoltage")
    private Double highVoltage;


    /** Enter service voltage low */
    @JsonProperty("lowVoltage")
    private Double lowVoltage;


    /** Enter service frequency high */
    @JsonProperty("highFreq")
    private Double highFreq;


    /** Enter service frequency low */
    @JsonProperty("lowFreq")
    private Double lowFreq;


    /** Enter service delay */
    @JsonProperty("delay")
    private Double delay;


    /** Enter service randomized delay */
    @JsonProperty("randomDelay")
    private Double randomDelay;


    /** Enter service ramp rate in seconds */
    @JsonProperty("rampRate")
    private Double rampRate;


    @JsonProperty("customData")
    private CustomData customData;

}
