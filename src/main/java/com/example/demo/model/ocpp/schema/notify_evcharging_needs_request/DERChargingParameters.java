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
public class DERChargingParameters {


    @ElementCollection
    @Size(min = 1)
    /** DER control functions supported by EV. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType:DERControlFunctions (bitmap) */
    @Column(name = "ev_supported_dercontrol")
    private List<DERControlEnum> evSupportedDERControl;

    @ElementCollection
    private List<DERControlEnum> evSupportedDERControl = new ArrayList<>();


    /** Rated maximum injected active power by EV, at specified over-excited power factor (overExcitedPowerFactor). + It can also be defined as the rated maximum discharge power at the rated minimum injected reactive power value. This means that if the EV is providing reactive power support, and it is requested to discharge at max power (e.g. to satisfy an EMS request), the EV may override the request and discharge up to overExcitedMaximumDischargePower to meet the minimum reactive power requirements. + Corresponds to the WOvPF attribute in IEC 61850. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVOverExcitedMaximumDischargePower */
    @Column(name = "ev_over_excited_max_discharge_power")
    private Double evOverExcitedMaxDischargePower;


    /** EV power factor when injecting (over excited) the minimum reactive power. + Corresponds to the OvPF attribute in IEC 61850. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVOverExcitedPowerFactor */
    @Column(name = "ev_over_excited_power_factor")
    private Double evOverExcitedPowerFactor;


    /** Rated maximum injected active power by EV supported at specified under-excited power factor (EVUnderExcitedPowerFactor). + It can also be defined as the rated maximum dischargePower at the rated minimum absorbed reactive power value. This means that if the EV is providing reactive power support, and it is requested to discharge at max power (e.g. to satisfy an EMS request), the EV may override the request and discharge up to underExcitedMaximumDischargePower to meet the minimum reactive power requirements. + This corresponds to the WUnPF attribute in the IEC 61850. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVUnderExcitedMaximumDischargePower */
    @Column(name = "ev_under_excited_max_discharge_power")
    private Double evUnderExcitedMaxDischargePower;


    /** EV power factor when injecting (under excited) the minimum reactive power. + Corresponds to the OvPF attribute in IEC 61850. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVUnderExcitedPowerFactor */
    @Column(name = "ev_under_excited_power_factor")
    private Double evUnderExcitedPowerFactor;


    /** Rated maximum total apparent power, defined by min(EV, EVSE) in va. Corresponds to the VAMaxRtg in IEC 61850. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumApparentPower */
    @Column(name = "max_apparent_power")
    private Double maxApparentPower;


    /** Rated maximum absorbed apparent power, defined by min(EV, EVSE) in va. + This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1. + Corresponds to the ChaVAMaxRtg in IEC 61850. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeApparentPower */
    @Column(name = "max_charge_apparent_power")
    private Double maxChargeApparentPower;


    /** Rated maximum absorbed apparent power on phase L2, defined by min(EV, EVSE) in va. Corresponds to the ChaVAMaxRtg in IEC 61850. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeApparentPower_L2 */
    @Column(name = "max_charge_apparent_power_l2")
    private Double maxChargeApparentPower_L2;


    /** Rated maximum absorbed apparent power on phase L3, defined by min(EV, EVSE) in va. Corresponds to the ChaVAMaxRtg in IEC 61850. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeApparentPower_L3 */
    @Column(name = "max_charge_apparent_power_l3")
    private Double maxChargeApparentPower_L3;


    /** Rated maximum injected apparent power, defined by min(EV, EVSE) in va. + This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1. + Corresponds to the DisVAMaxRtg in IEC 61850. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeApparentPower */
    @Column(name = "max_discharge_apparent_power")
    private Double maxDischargeApparentPower;


    /** Rated maximum injected apparent power on phase L2, defined by min(EV, EVSE) in va. + Corresponds to the DisVAMaxRtg in IEC 61850. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeApparentPower_L2 */
    @Column(name = "max_discharge_apparent_power_l2")
    private Double maxDischargeApparentPower_L2;


    /** Rated maximum injected apparent power on phase L3, defined by min(EV, EVSE) in va. + Corresponds to the DisVAMaxRtg in IEC 61850. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeApparentPower_L3 */
    @Column(name = "max_discharge_apparent_power_l3")
    private Double maxDischargeApparentPower_L3;


    /** Rated maximum absorbed reactive power, defined by min(EV, EVSE), in vars. + This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1. + Corresponds to the AvarMax attribute in the IEC 61850. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeReactivePower */
    @Column(name = "max_charge_reactive_power")
    private Double maxChargeReactivePower;


    /** Rated maximum absorbed reactive power, defined by min(EV, EVSE), in vars on phase L2. + Corresponds to the AvarMax attribute in the IEC 61850. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeReactivePower_L2 */
    @Column(name = "max_charge_reactive_power_l2")
    private Double maxChargeReactivePower_L2;


    /** Rated maximum absorbed reactive power, defined by min(EV, EVSE), in vars on phase L3. + Corresponds to the AvarMax attribute in the IEC 61850. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeReactivePower_L3 */
    @Column(name = "max_charge_reactive_power_l3")
    private Double maxChargeReactivePower_L3;


    /** Rated minimum absorbed reactive power, defined by max(EV, EVSE), in vars. + This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumChargeReactivePower */
    @Column(name = "min_charge_reactive_power")
    private Double minChargeReactivePower;


    /** Rated minimum absorbed reactive power, defined by max(EV, EVSE), in vars on phase L2. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumChargeReactivePower_L2 */
    @Column(name = "min_charge_reactive_power_l2")
    private Double minChargeReactivePower_L2;


    /** Rated minimum absorbed reactive power, defined by max(EV, EVSE), in vars on phase L3. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumChargeReactivePower_L3 */
    @Column(name = "min_charge_reactive_power_l3")
    private Double minChargeReactivePower_L3;


    /** Rated maximum injected reactive power, defined by min(EV, EVSE), in vars. + This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1. + Corresponds to the IvarMax attribute in the IEC 61850. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeReactivePower */
    @Column(name = "max_discharge_reactive_power")
    private Double maxDischargeReactivePower;


    /** Rated maximum injected reactive power, defined by min(EV, EVSE), in vars on phase L2. + Corresponds to the IvarMax attribute in the IEC 61850. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeReactivePower_L2 */
    @Column(name = "max_discharge_reactive_power_l2")
    private Double maxDischargeReactivePower_L2;


    /** Rated maximum injected reactive power, defined by min(EV, EVSE), in vars on phase L3. + Corresponds to the IvarMax attribute in the IEC 61850. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeReactivePower_L3 */
    @Column(name = "max_discharge_reactive_power_l3")
    private Double maxDischargeReactivePower_L3;


    /** Rated minimum injected reactive power, defined by max(EV, EVSE), in vars. + This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumDischargeReactivePower */
    @Column(name = "min_discharge_reactive_power")
    private Double minDischargeReactivePower;


    /** Rated minimum injected reactive power, defined by max(EV, EVSE), in var on phase L2. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumDischargeReactivePower_L2 */
    @Column(name = "min_discharge_reactive_power_l2")
    private Double minDischargeReactivePower_L2;


    /** Rated minimum injected reactive power, defined by max(EV, EVSE), in var on phase L3. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumDischargeReactivePower_L3 */
    @Column(name = "min_discharge_reactive_power_l3")
    private Double minDischargeReactivePower_L3;


    /** Line voltage supported by EVSE and EV. *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVNominalVoltage */
    @Column(name = "nominal_voltage")
    private Double nominalVoltage;


    /** The nominal AC voltage (rms) offset between the Charging Station's electrical connection point and the utility’s point of common coupling. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVNominalVoltageOffset */
    @Column(name = "nominal_voltage_offset")
    private Double nominalVoltageOffset;


    /** Maximum AC rms voltage, as defined by min(EV, EVSE) to operate with. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumNominalVoltage */
    @Column(name = "max_nominal_voltage")
    private Double maxNominalVoltage;


    /** Minimum AC rms voltage, as defined by max(EV, EVSE) to operate with. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumNominalVoltage */
    @Column(name = "min_nominal_voltage")
    private Double minNominalVoltage;


    @Size(max = 50)
    /** Manufacturer of the EV inverter. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterManufacturer */
    @Column(name = "ev_inverter_manufacturer")
    private String evInverterManufacturer;


    @Size(max = 50)
    /** Model name of the EV inverter. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterModel */
    @Column(name = "ev_inverter_model")
    private String evInverterModel;


    @Size(max = 50)
    /** Serial number of the EV inverter. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterSerialNumber */
    @Column(name = "ev_inverter_serial_number")
    private String evInverterSerialNumber;


    @Size(max = 50)
    /** Software version of EV inverter. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterSwVersion */
    @Column(name = "ev_inverter_sw_version")
    private String evInverterSwVersion;


    @Size(max = 50)
    /** Hardware version of EV inverter. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterHwVersion */
    @Column(name = "ev_inverter_hw_version")
    private String evInverterHwVersion;


    @ElementCollection
    @Size(min = 1)
    /** Type of islanding detection method. Only mandatory when islanding detection is required at the site, as set in the ISO 15118 Service Details configuration. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVIslandingDetectionMethod */
    @Column(name = "ev_islanding_detection_method")
    private List<IslandingDetectionEnum> evIslandingDetectionMethod;

    @ElementCollection
    private List<IslandingDetectionEnum> evIslandingDetectionMethod = new ArrayList<>();


    /** Time after which EV will trip if an island has been detected. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVIslandingTripTime */
    @Column(name = "ev_islanding_trip_time")
    private Double evIslandingTripTime;


    /** Maximum injected DC current allowed at level 1 charging. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumLevel1DCInjection */
    @Column(name = "ev_maximum_level1dcinjection")
    private Double evMaximumLevel1DCInjection;


    /** Maximum allowed duration of DC injection at level 1 charging. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVDurationLevel1DCInjection */
    @Column(name = "ev_duration_level1dcinjection")
    private Double evDurationLevel1DCInjection;


    /** Maximum injected DC current allowed at level 2 charging. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumLevel2DCInjection */
    @Column(name = "ev_maximum_level2dcinjection")
    private Double evMaximumLevel2DCInjection;


    /** Maximum allowed duration of DC injection at level 2 charging. + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVDurationLevel2DCInjection */
    @Column(name = "ev_duration_level2dcinjection")
    private Double evDurationLevel2DCInjection;


    /** Measure of the susceptibility of the circuit to reactance, in Siemens (S). + *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVReactiveSusceptance */
    @Column(name = "ev_reactive_susceptance")
    private Double evReactiveSusceptance;


    /** Total energy value, in Wh, that EV is allowed to provide during the entire V2G session. The value is independent of the V2X Cycling area. Once this value reaches the value of 0, the EV may block any attempt to discharge in order to protect the battery health. *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVSessionTotalDischargeEnergyAvailable */
    @Column(name = "ev_session_total_discharge_energy_available")
    private Double evSessionTotalDischargeEnergyAvailable;


    @Column(name = "custom_data")
    private CustomData customData;

}
