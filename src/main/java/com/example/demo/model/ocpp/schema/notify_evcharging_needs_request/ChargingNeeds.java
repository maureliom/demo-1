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
public class ChargingNeeds {


    @Column(name = "ac_charging_parameters")
    private ACChargingParameters acChargingParameters;


    @Column(name = "der_charging_parameters")
    private DERChargingParameters derChargingParameters;


    @Column(name = "ev_energy_offer")
    private EVEnergyOffer evEnergyOffer;


    @Column(name = "requested_energy_transfer")
    private EnergyTransferModeEnum requestedEnergyTransfer;


    @Column(name = "dc_charging_parameters")
    private DCChargingParameters dcChargingParameters;


    @Column(name = "v2x_charging_parameters")
    private V2XChargingParameters v2xChargingParameters;


    @ElementCollection
    @Size(min = 1)
    /** *(2.1)* Modes of energy transfer that are marked as available by EV. */
    @Column(name = "available_energy_transfer")
    private List<EnergyTransferModeEnum> availableEnergyTransfer;

    @ElementCollection
    private List<EnergyTransferModeEnum> availableEnergyTransfer = new ArrayList<>();


    @Column(name = "control_mode")
    private ControlModeEnum controlMode;


    @Column(name = "mobility_needs_mode")
    private MobilityNeedsModeEnum mobilityNeedsMode;


    /** Estimated departure time of the EV. + *ISO 15118-2:* AC/DC_EVChargeParameterType: DepartureTime + *ISO 15118-20:* Dynamic/Scheduled_SEReqControlModeType: DepartureTIme */
    @Column(name = "departure_time")
    private String departureTime;


    @Column(name = "custom_data")
    private CustomData customData;

}
