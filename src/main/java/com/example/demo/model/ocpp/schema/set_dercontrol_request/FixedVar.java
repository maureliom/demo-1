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
public class FixedVar {


    @Min(0)
    /** Priority of setting (0=highest) */
    @Column(name = "priority")
    private Integer priority;

    @Min(0.0)

    /** The value specifies a target var output interpreted as a signed percentage (-100 to 100). A negative value refers to charging, whereas a positive one refers to discharging. The value type is determined by the unit field. */
    @Column(name = "setpoint")
    private Double setpoint;


    @Column(name = "unit")
    private DERUnitEnum unit;


    /** Time when this setting becomes active. */
    @Column(name = "start_time")
    private String startTime;


    /** Duration in seconds that this setting is active. */
    @Column(name = "duration")
    private Double duration;


    @Column(name = "custom_data")
    private CustomData customData;

}
