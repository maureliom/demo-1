package com.example.demo.dto.ocpp.schema.notify_evcharging_needs_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ACChargingParameters {


    /** Amount of energy requested (in Wh). This includes energy required for preconditioning. Relates to: + *ISO 15118-2*: AC_EVChargeParameterType: EAmount + *ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVTargetEnergyRequest */
    @JsonProperty("energyAmount")
    private Double energyAmount;


    /** Minimum current (amps) supported by the electric vehicle (per phase). Relates to: + *ISO 15118-2*: AC_EVChargeParameterType: EVMinCurrent */
    @JsonProperty("evMinCurrent")
    private Double evMinCurrent;


    /** Maximum current (amps) supported by the electric vehicle (per phase). Includes cable capacity. Relates to: + *ISO 15118-2*: AC_EVChargeParameterType: EVMaxCurrent */
    @JsonProperty("evMaxCurrent")
    private Double evMaxCurrent;


    /** Maximum voltage supported by the electric vehicle. Relates to: + *ISO 15118-2*: AC_EVChargeParameterType: EVMaxVoltage */
    @JsonProperty("evMaxVoltage")
    private Double evMaxVoltage;


    @JsonProperty("customData")
    private CustomData customData;

}
