package com.example.demo.model.ocpp.schema.set_dercontrol_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class FixedPF {


    @Min(0)
    /** Priority of setting (0=highest) */
    @Column(name = "priority")
    private Integer priority;

    @Min(0.0)

    /** Power factor, cos(phi), as value between 0..1. */
    @Column(name = "displacement")
    private Double displacement;


    /** True when absorbing reactive power (under-excited), false when injecting reactive power (over-excited). */
    @Column(name = "excitation")
    private Boolean excitation;


    /** Time when this setting becomes active */
    @Column(name = "start_time")
    private String startTime;


    /** Duration in seconds that this setting is active. */
    @Column(name = "duration")
    private Double duration;


    @Column(name = "custom_data")
    private CustomData customData;

}
