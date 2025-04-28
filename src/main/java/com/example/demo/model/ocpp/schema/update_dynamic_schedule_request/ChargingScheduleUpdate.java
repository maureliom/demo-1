package com.example.demo.model.ocpp.schema.update_dynamic_schedule_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ChargingScheduleUpdate {


    /** Optional only when not required by the _operationMode_, as in CentralSetpoint, ExternalSetpoint, ExternalLimits, LocalFrequency, LocalLoadBalancing. + Charging rate limit during the schedule period, in the applicable _chargingRateUnit_. This SHOULD be a non-negative value; a negative value is only supported for backwards compatibility with older systems that use a negative value to specify a discharging limit. For AC this field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1. */
    @Column(name = "limit")
    private Double limit;


    /** *(2.1)* Charging rate limit on phase L2 in the applicable _chargingRateUnit_. */
    @Column(name = "limit_l2")
    private Double limit_L2;


    /** *(2.1)* Charging rate limit on phase L3 in the applicable _chargingRateUnit_. */
    @Column(name = "limit_l3")
    private Double limit_L3;


    @Max(0)
    /** *(2.1)* Limit in _chargingRateUnit_ that the EV is allowed to discharge with. Note, these are negative values in order to be consistent with _setpoint_, which can be positive and negative. + For AC this field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1. */
    @Column(name = "discharge_limit")
    private Double dischargeLimit;

    @Max(0.0)

    @Max(0)
    /** *(2.1)* Limit in _chargingRateUnit_ on phase L2 that the EV is allowed to discharge with. */
    @Column(name = "discharge_limit_l2")
    private Double dischargeLimit_L2;

    @Max(0.0)

    @Max(0)
    /** *(2.1)* Limit in _chargingRateUnit_ on phase L3 that the EV is allowed to discharge with. */
    @Column(name = "discharge_limit_l3")
    private Double dischargeLimit_L3;

    @Max(0.0)

    /** *(2.1)* Setpoint in _chargingRateUnit_ that the EV should follow as close as possible. Use negative values for discharging. + When a limit and/or _dischargeLimit_ are given the overshoot when following _setpoint_ must remain within these values. This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1. */
    @Column(name = "setpoint")
    private Double setpoint;


    /** *(2.1)* Setpoint in _chargingRateUnit_ that the EV should follow on phase L2 as close as possible. */
    @Column(name = "setpoint_l2")
    private Double setpoint_L2;


    /** *(2.1)* Setpoint in _chargingRateUnit_ that the EV should follow on phase L3 as close as possible. */
    @Column(name = "setpoint_l3")
    private Double setpoint_L3;


    /** *(2.1)* Setpoint for reactive power (or current) in _chargingRateUnit_ that the EV should follow as closely as possible. Positive values for inductive, negative for capacitive reactive power or current. + This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1. */
    @Column(name = "setpoint_reactive")
    private Double setpointReactive;


    /** *(2.1)* Setpoint for reactive power (or current) in _chargingRateUnit_ that the EV should follow on phase L2 as closely as possible. */
    @Column(name = "setpoint_reactive_l2")
    private Double setpointReactive_L2;


    /** *(2.1)* Setpoint for reactive power (or current) in _chargingRateUnit_ that the EV should follow on phase L3 as closely as possible. */
    @Column(name = "setpoint_reactive_l3")
    private Double setpointReactive_L3;


    @Column(name = "custom_data")
    private CustomData customData;

}
