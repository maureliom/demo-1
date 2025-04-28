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
public class EnterService {


    @Min(0)
    /** Priority of setting (0=highest) */
    @Column(name = "priority")
    private Integer priority;

    @Min(0.0)

    /** Enter service voltage high */
    @Column(name = "high_voltage")
    private Double highVoltage;


    /** Enter service voltage low */
    @Column(name = "low_voltage")
    private Double lowVoltage;


    /** Enter service frequency high */
    @Column(name = "high_freq")
    private Double highFreq;


    /** Enter service frequency low */
    @Column(name = "low_freq")
    private Double lowFreq;


    /** Enter service delay */
    @Column(name = "delay")
    private Double delay;


    /** Enter service randomized delay */
    @Column(name = "random_delay")
    private Double randomDelay;


    /** Enter service ramp rate in seconds */
    @Column(name = "ramp_rate")
    private Double rampRate;


    @Column(name = "custom_data")
    private CustomData customData;

}
