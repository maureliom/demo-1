package com.example.demo.model.ocpp.schema.report_dercontrol_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class Hysteresis {


    /** High value for return to normal operation after a grid event, in absolute value. This value adopts the same unit as defined by yUnit */
    @Column(name = "hysteresis_high")
    private Double hysteresisHigh;


    /** Low value for return to normal operation after a grid event, in absolute value. This value adopts the same unit as defined by yUnit */
    @Column(name = "hysteresis_low")
    private Double hysteresisLow;


    /** Delay in seconds, once grid parameter within HysteresisLow and HysteresisHigh, for the EV to return to normal operation after a grid event. */
    @Column(name = "hysteresis_delay")
    private Double hysteresisDelay;


    /** Set default rate of change (ramp rate %/s) for the EV to return to normal operation after a grid event */
    @Column(name = "hysteresis_gradient")
    private Double hysteresisGradient;


    @Column(name = "custom_data")
    private CustomData customData;

}
