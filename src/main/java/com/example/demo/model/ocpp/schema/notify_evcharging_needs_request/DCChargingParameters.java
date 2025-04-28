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
public class DCChargingParameters {


    /** Maximum current (in A) supported by the electric vehicle. Includes cable capacity. Relates to: + *ISO 15118-2*: DC_EVChargeParameterType:EVMaximumCurrentLimit */
    @Column(name = "ev_max_current")
    private Double evMaxCurrent;


    /** Maximum voltage supported by the electric vehicle. Relates to: + *ISO 15118-2*: DC_EVChargeParameterType: EVMaximumVoltageLimit */
    @Column(name = "ev_max_voltage")
    private Double evMaxVoltage;


    /** Maximum power (in W) supported by the electric vehicle. Required for DC charging. Relates to: + *ISO 15118-2*: DC_EVChargeParameterType: EVMaximumPowerLimit */
    @Column(name = "ev_max_power")
    private Double evMaxPower;


    /** Capacity of the electric vehicle battery (in Wh). Relates to: + *ISO 15118-2*: DC_EVChargeParameterType: EVEnergyCapacity */
    @Column(name = "ev_energy_capacity")
    private Double evEnergyCapacity;


    /** Amount of energy requested (in Wh). This inludes energy required for preconditioning. Relates to: + *ISO 15118-2*: DC_EVChargeParameterType: EVEnergyRequest */
    @Column(name = "energy_amount")
    private Double energyAmount;


    @Min(0)
    @Max(100)
    /** Energy available in the battery (in percent of the battery capacity) Relates to: + *ISO 15118-2*: DC_EVChargeParameterType: DC_EVStatus: EVRESSSOC */
    @Column(name = "state_of_charge")
    private Integer stateOfCharge;

    @Min(0.0)
    @Max(100.0)

    @Min(0)
    @Max(100)
    /** Percentage of SoC at which the EV considers the battery fully charged. (possible values: 0 - 100) Relates to: + *ISO 15118-2*: DC_EVChargeParameterType: FullSOC */
    @Column(name = "full_so_c")
    private Integer fullSoC;

    @Min(0.0)
    @Max(100.0)

    @Min(0)
    @Max(100)
    /** Percentage of SoC at which the EV considers a fast charging process to end. (possible values: 0 - 100) Relates to: + *ISO 15118-2*: DC_EVChargeParameterType: BulkSOC */
    @Column(name = "bulk_so_c")
    private Integer bulkSoC;

    @Min(0.0)
    @Max(100.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
