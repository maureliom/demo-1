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
public class FreqDroop {


    @Min(0)
    /** Priority of setting (0=highest) */
    @Column(name = "priority")
    private Integer priority;

    @Min(0.0)

    /** Over-frequency start of droop */
    @Column(name = "over_freq")
    private Double overFreq;


    /** Under-frequency start of droop */
    @Column(name = "under_freq")
    private Double underFreq;


    /** Over-frequency droop per unit, oFDroop */
    @Column(name = "over_droop")
    private Double overDroop;


    /** Under-frequency droop per unit, uFDroop */
    @Column(name = "under_droop")
    private Double underDroop;


    /** Open loop response time in seconds */
    @Column(name = "response_time")
    private Double responseTime;


    /** Time when this setting becomes active */
    @Column(name = "start_time")
    private String startTime;


    /** Duration in seconds that this setting is active */
    @Column(name = "duration")
    private Double duration;


    @Column(name = "custom_data")
    private CustomData customData;

}
