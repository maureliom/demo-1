package com.example.demo.dto.ocpp.schema.notify_evcharging_needs_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ChargingNeeds {


    @JsonProperty("acChargingParameters")
    private ACChargingParameters acChargingParameters;


    @JsonProperty("derChargingParameters")
    private DERChargingParameters derChargingParameters;


    @JsonProperty("evEnergyOffer")
    private EVEnergyOffer evEnergyOffer;


    @JsonProperty("requestedEnergyTransfer")
    private EnergyTransferModeEnum requestedEnergyTransfer;


    @JsonProperty("dcChargingParameters")
    private DCChargingParameters dcChargingParameters;


    @JsonProperty("v2xChargingParameters")
    private V2XChargingParameters v2xChargingParameters;


    @ElementCollection
    @Size(min = 1)
    /** *(2.1)* Modes of energy transfer that are marked as available by EV. */
    @JsonProperty("availableEnergyTransfer")
    private List<EnergyTransferModeEnum> availableEnergyTransfer;

    @JsonProperty("availableEnergyTransfer")
    private List<EnergyTransferModeEnum> availableEnergyTransfer = new ArrayList<>();


    @JsonProperty("controlMode")
    private ControlModeEnum controlMode;


    @JsonProperty("mobilityNeedsMode")
    private MobilityNeedsModeEnum mobilityNeedsMode;


    /** Estimated departure time of the EV. + *ISO 15118-2:* AC/DC_EVChargeParameterType: DepartureTime + *ISO 15118-20:* Dynamic/Scheduled_SEReqControlModeType: DepartureTIme */
    @JsonProperty("departureTime")
    private String departureTime;


    @JsonProperty("customData")
    private CustomData customData;

}
