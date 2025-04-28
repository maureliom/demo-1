package com.example.demo.dto.ocpp.schema.notify_evcharging_needs_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class V2XChargingParameters {


    /** Minimum charge power in W, defined by max(EV, EVSE). This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1. Relates to: *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumChargePower */
    @JsonProperty("minChargePower")
    private Double minChargePower;


    /** Minimum charge power on phase L2 in W, defined by max(EV, EVSE). Relates to: *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumChargePower_L2 */
    @JsonProperty("minChargePower_L2")
    private Double minChargePower_L2;


    /** Minimum charge power on phase L3 in W, defined by max(EV, EVSE). Relates to: *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumChargePower_L3 */
    @JsonProperty("minChargePower_L3")
    private Double minChargePower_L3;


    /** Maximum charge (absorbed) power in W, defined by min(EV, EVSE) at unity power factor. + This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1. It corresponds to the ChaWMax attribute in the IEC 61850. It is usually equivalent to the rated apparent power of the EV when discharging (ChaVAMax) in IEC 61850. + Relates to: *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumChargePower */
    @JsonProperty("maxChargePower")
    private Double maxChargePower;


    /** Maximum charge power on phase L2 in W, defined by min(EV, EVSE) Relates to: *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumChargePower_L2 */
    @JsonProperty("maxChargePower_L2")
    private Double maxChargePower_L2;


    /** Maximum charge power on phase L3 in W, defined by min(EV, EVSE) Relates to: *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumChargePower_L3 */
    @JsonProperty("maxChargePower_L3")
    private Double maxChargePower_L3;


    /** Minimum discharge (injected) power in W, defined by max(EV, EVSE) at unity power factor. Value &gt;= 0. + This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1. + It corresponds to the WMax attribute in the IEC 61850. It is usually equivalent to the rated apparent power of the EV when discharging (VAMax attribute in the IEC 61850). Relates to: *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumDischargePower */
    @JsonProperty("minDischargePower")
    private Double minDischargePower;


    /** Minimum discharge power on phase L2 in W, defined by max(EV, EVSE). Value &gt;= 0. Relates to: *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumDischargePower_L2 */
    @JsonProperty("minDischargePower_L2")
    private Double minDischargePower_L2;


    /** Minimum discharge power on phase L3 in W, defined by max(EV, EVSE). Value &gt;= 0. Relates to: *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumDischargePower_L3 */
    @JsonProperty("minDischargePower_L3")
    private Double minDischargePower_L3;


    /** Maximum discharge (injected) power in W, defined by min(EV, EVSE) at unity power factor. Value &gt;= 0. This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1. Relates to: *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumDischargePower */
    @JsonProperty("maxDischargePower")
    private Double maxDischargePower;


    /** Maximum discharge power on phase L2 in W, defined by min(EV, EVSE). Value &gt;= 0. Relates to: *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumDischargePowe_L2 */
    @JsonProperty("maxDischargePower_L2")
    private Double maxDischargePower_L2;


    /** Maximum discharge power on phase L3 in W, defined by min(EV, EVSE). Value &gt;= 0. Relates to: *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumDischargePower_L3 */
    @JsonProperty("maxDischargePower_L3")
    private Double maxDischargePower_L3;


    /** Minimum charge current in A, defined by max(EV, EVSE) Relates to: *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMinimumChargeCurrent */
    @JsonProperty("minChargeCurrent")
    private Double minChargeCurrent;


    /** Maximum charge current in A, defined by min(EV, EVSE) Relates to: *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMaximumChargeCurrent */
    @JsonProperty("maxChargeCurrent")
    private Double maxChargeCurrent;


    /** Minimum discharge current in A, defined by max(EV, EVSE). Value &gt;= 0. Relates to: *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMinimumDischargeCurrent */
    @JsonProperty("minDischargeCurrent")
    private Double minDischargeCurrent;


    /** Maximum discharge current in A, defined by min(EV, EVSE). Value &gt;= 0. Relates to: *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMaximumDischargeCurrent */
    @JsonProperty("maxDischargeCurrent")
    private Double maxDischargeCurrent;


    /** Minimum voltage in V, defined by max(EV, EVSE) Relates to: *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMinimumVoltage */
    @JsonProperty("minVoltage")
    private Double minVoltage;


    /** Maximum voltage in V, defined by min(EV, EVSE) Relates to: *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMaximumVoltage */
    @JsonProperty("maxVoltage")
    private Double maxVoltage;


    /** Energy to requested state of charge in Wh Relates to: *ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVTargetEnergyRequest */
    @JsonProperty("evTargetEnergyRequest")
    private Double evTargetEnergyRequest;


    /** Energy to minimum allowed state of charge in Wh Relates to: *ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVMinimumEnergyRequest */
    @JsonProperty("evMinEnergyRequest")
    private Double evMinEnergyRequest;


    /** Energy to maximum state of charge in Wh Relates to: *ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVMaximumEnergyRequest */
    @JsonProperty("evMaxEnergyRequest")
    private Double evMaxEnergyRequest;


    /** Energy (in Wh) to minimum state of charge for cycling (V2X) activity. Positive value means that current state of charge is below V2X range. Relates to: *ISO 15118-20*: Dynamic_SEReqControlModeType: EVMinimumV2XEnergyRequest */
    @JsonProperty("evMinV2XEnergyRequest")
    private Double evMinV2XEnergyRequest;


    /** Energy (in Wh) to maximum state of charge for cycling (V2X) activity. Negative value indicates that current state of charge is above V2X range. Relates to: *ISO 15118-20*: Dynamic_SEReqControlModeType: EVMaximumV2XEnergyRequest */
    @JsonProperty("evMaxV2XEnergyRequest")
    private Double evMaxV2XEnergyRequest;


    @Min(0)
    @Max(100)
    /** Target state of charge at departure as percentage. Relates to: *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: TargetSOC */
    @JsonProperty("targetSoC")
    private Integer targetSoC;

    @Min(0.0)
    @Max(100.0)

    @JsonProperty("customData")
    private CustomData customData;

}
