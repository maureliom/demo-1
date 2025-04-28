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
@Entity
@Table(name = "notify_evcharging_needs_request")
public class NotifyEVChargingNeedsRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Min(1)
    /** Defines the EVSE and connector to which the EV is connected. EvseId may not be 0. */
    @Column(name = "evse_id")
    private Integer evseId;

    @Min(1.0)

    @Min(0)
    /** Contains the maximum elements the EV supports for: + - ISO 15118-2: schedule tuples in SASchedule (both Pmax and Tariff). + - ISO 15118-20: PowerScheduleEntry, PriceRule and PriceLevelScheduleEntries. */
    @Column(name = "max_schedule_tuples")
    private Integer maxScheduleTuples;

    @Min(0.0)

    @Column(name = "charging_needs")
    private ChargingNeeds chargingNeeds;


    /** *(2.1)* Time when EV charging needs were received. + Field can be added when charging station was offline when charging needs were received. */
    @Column(name = "timestamp")
    private String timestamp;


    @Column(name = "custom_data")
    private CustomData customData;

}
