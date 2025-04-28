package com.example.demo.dto.ocpp.schema.report_dercontrol_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class Hysteresis {


    /** High value for return to normal operation after a grid event, in absolute value. This value adopts the same unit as defined by yUnit */
    @JsonProperty("hysteresisHigh")
    private Double hysteresisHigh;


    /** Low value for return to normal operation after a grid event, in absolute value. This value adopts the same unit as defined by yUnit */
    @JsonProperty("hysteresisLow")
    private Double hysteresisLow;


    /** Delay in seconds, once grid parameter within HysteresisLow and HysteresisHigh, for the EV to return to normal operation after a grid event. */
    @JsonProperty("hysteresisDelay")
    private Double hysteresisDelay;


    /** Set default rate of change (ramp rate %/s) for the EV to return to normal operation after a grid event */
    @JsonProperty("hysteresisGradient")
    private Double hysteresisGradient;


    @JsonProperty("customData")
    private CustomData customData;

}
