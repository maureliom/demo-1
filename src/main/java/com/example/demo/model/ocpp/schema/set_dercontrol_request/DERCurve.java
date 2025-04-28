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
public class DERCurve {


    @ElementCollection
    @Size(min = 1)
    @Size(max = 10)
    @Column(name = "curve_data")
    private List<DERCurvePoints> curveData;

    @ElementCollection
    private List<DERCurvePoints> curveData = new ArrayList<>();


    @Column(name = "hysteresis")
    private Hysteresis hysteresis;


    @Min(0)
    /** Priority of curve (0=highest) */
    @Column(name = "priority")
    private Integer priority;

    @Min(0.0)

    @Column(name = "reactive_power_params")
    private ReactivePowerParams reactivePowerParams;


    @Column(name = "voltage_params")
    private VoltageParams voltageParams;


    @Column(name = "y_unit")
    private DERUnitEnum yUnit;


    /** Open loop response time, the time to ramp up to 90% of the new target in response to the change in voltage, in seconds. A value of 0 is used to mean no limit. When not present, the device should follow its default behavior. */
    @Column(name = "response_time")
    private Double responseTime;


    /** Point in time when this curve will become activated. Only absent when _default_ is true. */
    @Column(name = "start_time")
    private String startTime;


    /** Duration in seconds that this curve will be active. Only absent when _default_ is true. */
    @Column(name = "duration")
    private Double duration;


    @Column(name = "custom_data")
    private CustomData customData;

}
