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
public class V2XChargingParameters {


    /** Minimum charge power in W, defined by max(EV, EVSE). This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1. Relates to: *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumChargePower */
    @Column(name = "min_charge_power")
    private Double minChargePower;


    /** Minimum charge power on phase L2 in W, defined by max(EV, EVSE). Relates to: *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumChargePower_L2 */
    @Column(name = "min_charge_power_l2")
    private Double minChargePower_L2;


    /** Minimum charge power on phase L3 in W, defined by max(EV, EVSE). Relates to: *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumChargePower_L3 */
    @Column(name = "min_charge_power_l3")
    private Double minChargePower_L3;


    /** Maximum charge (absorbed) power in W, defined by min(EV, EVSE) at unity power factor. + This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1. It corresponds to the ChaWMax attribute in the IEC 61850. It is usually equivalent to the rated apparent power of the EV when discharging (ChaVAMax) in IEC 61850. + Relates to: *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumChargePower */
    @Column(name = "max_charge_power")
    private Double maxChargePower;


    /** Maximum charge power on phase L2 in W, defined by min(EV, EVSE) Relates to: *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumChargePower_L2 */
    @Column(name = "max_charge_power_l2")
    private Double maxChargePower_L2;


    /** Maximum charge power on phase L3 in W, defined by min(EV, EVSE) Relates to: *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumChargePower_L3 */
    @Column(name = "max_charge_power_l3")
    private Double maxChargePower_L3;


    /** Minimum discharge (injected) power in W, defined by max(EV, EVSE) at unity power factor. Value &gt;= 0. + This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1. + It corresponds to the WMax attribute in the IEC 61850. It is usually equivalent to the rated apparent power of the EV when discharging (VAMax attribute in the IEC 61850). Relates to: *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumDischargePower */
    @Column(name = "min_discharge_power")
    private Double minDischargePower;


    /** Minimum discharge power on phase L2 in W, defined by max(EV, EVSE). Value &gt;= 0. Relates to: *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumDischargePower_L2 */
    @Column(name = "min_discharge_power_l2")
    private Double minDischargePower_L2;


    /** Minimum discharge power on phase L3 in W, defined by max(EV, EVSE). Value &gt;= 0. Relates to: *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumDischargePower_L3 */
    @Column(name = "min_discharge_power_l3")
    private Double minDischargePower_L3;


    /** Maximum discharge (injected) power in W, defined by min(EV, EVSE) at unity power factor. Value &gt;= 0. This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1. Relates to: *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumDischargePower */
    @Column(name = "max_discharge_power")
    private Double maxDischargePower;


    /** Maximum discharge power on phase L2 in W, defined by min(EV, EVSE). Value &gt;= 0. Relates to: *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumDischargePowe_L2 */
    @Column(name = "max_discharge_power_l2")
    private Double maxDischargePower_L2;


    /** Maximum discharge power on phase L3 in W, defined by min(EV, EVSE). Value &gt;= 0. Relates to: *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumDischargePower_L3 */
    @Column(name = "max_discharge_power_l3")
    private Double maxDischargePower_L3;


    /** Minimum charge current in A, defined by max(EV, EVSE) Relates to: *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMinimumChargeCurrent */
    @Column(name = "min_charge_current")
    private Double minChargeCurrent;


    /** Maximum charge current in A, defined by min(EV, EVSE) Relates to: *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMaximumChargeCurrent */
    @Column(name = "max_charge_current")
    private Double maxChargeCurrent;


    /** Minimum discharge current in A, defined by max(EV, EVSE). Value &gt;= 0. Relates to: *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMinimumDischargeCurrent */
    @Column(name = "min_discharge_current")
    private Double minDischargeCurrent;


    /** Maximum discharge current in A, defined by min(EV, EVSE). Value &gt;= 0. Relates to: *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMaximumDischargeCurrent */
    @Column(name = "max_discharge_current")
    private Double maxDischargeCurrent;


    /** Minimum voltage in V, defined by max(EV, EVSE) Relates to: *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMinimumVoltage */
    @Column(name = "min_voltage")
    private Double minVoltage;


    /** Maximum voltage in V, defined by min(EV, EVSE) Relates to: *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMaximumVoltage */
    @Column(name = "max_voltage")
    private Double maxVoltage;


    /** Energy to requested state of charge in Wh Relates to: *ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVTargetEnergyRequest */
    @Column(name = "ev_target_energy_request")
    private Double evTargetEnergyRequest;


    /** Energy to minimum allowed state of charge in Wh Relates to: *ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVMinimumEnergyRequest */
    @Column(name = "ev_min_energy_request")
    private Double evMinEnergyRequest;


    /** Energy to maximum state of charge in Wh Relates to: *ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVMaximumEnergyRequest */
    @Column(name = "ev_max_energy_request")
    private Double evMaxEnergyRequest;


    /** Energy (in Wh) to minimum state of charge for cycling (V2X) activity. Positive value means that current state of charge is below V2X range. Relates to: *ISO 15118-20*: Dynamic_SEReqControlModeType: EVMinimumV2XEnergyRequest */
    @Column(name = "ev_min_v2xenergy_request")
    private Double evMinV2XEnergyRequest;


    /** Energy (in Wh) to maximum state of charge for cycling (V2X) activity. Negative value indicates that current state of charge is above V2X range. Relates to: *ISO 15118-20*: Dynamic_SEReqControlModeType: EVMaximumV2XEnergyRequest */
    @Column(name = "ev_max_v2xenergy_request")
    private Double evMaxV2XEnergyRequest;


    @Min(0)
    @Max(100)
    /** Target state of charge at departure as percentage. Relates to: *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: TargetSOC */
    @Column(name = "target_so_c")
    private Integer targetSoC;

    @Min(0.0)
    @Max(100.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
