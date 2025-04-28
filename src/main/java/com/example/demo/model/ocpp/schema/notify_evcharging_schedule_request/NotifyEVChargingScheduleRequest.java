package com.example.demo.model.ocpp.schema.notify_evcharging_schedule_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "notify_evcharging_schedule_request")
public class NotifyEVChargingScheduleRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    /** Periods contained in the charging profile are relative to this point in time. */
    @Column(name = "time_base")
    private String timeBase;


    @Column(name = "charging_schedule")
    private ChargingSchedule chargingSchedule;


    @Min(1)
    /** The charging schedule contained in this notification applies to an EVSE. EvseId must be &gt; 0. */
    @Column(name = "evse_id")
    private Integer evseId;

    @Min(1.0)

    @Min(0)
    /** *(2.1)* Id of the _chargingSchedule_ that EV selected from the provided ChargingProfile. */
    @Column(name = "selected_charging_schedule_id")
    private Integer selectedChargingScheduleId;

    @Min(0.0)

    /** *(2.1)* True when power tolerance is accepted by EV. This value is taken from EVPowerProfile.PowerToleranceAcceptance in the ISO 15118-20 PowerDeliverReq message.. */
    @Column(name = "power_tolerance_acceptance")
    private Boolean powerToleranceAcceptance;


    @Column(name = "custom_data")
    private CustomData customData;

}
