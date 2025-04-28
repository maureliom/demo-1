package com.example.demo.model.ocpp.schema.notify_evcharging_needs_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ACChargingParameters {


    /** Amount of energy requested (in Wh). This includes energy required for preconditioning. Relates to: + *ISO 15118-2*: AC_EVChargeParameterType: EAmount + *ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVTargetEnergyRequest */
    @Column(name = "energy_amount")
    private Double energyAmount;


    /** Minimum current (amps) supported by the electric vehicle (per phase). Relates to: + *ISO 15118-2*: AC_EVChargeParameterType: EVMinCurrent */
    @Column(name = "ev_min_current")
    private Double evMinCurrent;


    /** Maximum current (amps) supported by the electric vehicle (per phase). Includes cable capacity. Relates to: + *ISO 15118-2*: AC_EVChargeParameterType: EVMaxCurrent */
    @Column(name = "ev_max_current")
    private Double evMaxCurrent;


    /** Maximum voltage supported by the electric vehicle. Relates to: + *ISO 15118-2*: AC_EVChargeParameterType: EVMaxVoltage */
    @Column(name = "ev_max_voltage")
    private Double evMaxVoltage;


    @Column(name = "custom_data")
    private CustomData customData;

}
