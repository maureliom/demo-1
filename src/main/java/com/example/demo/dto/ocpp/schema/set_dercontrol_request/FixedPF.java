package com.example.demo.dto.ocpp.schema.set_dercontrol_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class FixedPF {


    @Min(0)
    /** Priority of setting (0=highest) */
    @JsonProperty("priority")
    private Integer priority;

    @Min(0.0)

    /** Power factor, cos(phi), as value between 0..1. */
    @JsonProperty("displacement")
    private Double displacement;


    /** True when absorbing reactive power (under-excited), false when injecting reactive power (over-excited). */
    @JsonProperty("excitation")
    private Boolean excitation;


    /** Time when this setting becomes active */
    @JsonProperty("startTime")
    private String startTime;


    /** Duration in seconds that this setting is active. */
    @JsonProperty("duration")
    private Double duration;


    @JsonProperty("customData")
    private CustomData customData;

}
