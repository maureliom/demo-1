package com.example.demo.dto.ocpp.schema.notify_evcharging_needs_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class NotifyEVChargingNeedsRequest {


    @Min(1)
    /** Defines the EVSE and connector to which the EV is connected. EvseId may not be 0. */
    @JsonProperty("evseId")
    private Integer evseId;

    @Min(1.0)

    @Min(0)
    /** Contains the maximum elements the EV supports for: + - ISO 15118-2: schedule tuples in SASchedule (both Pmax and Tariff). + - ISO 15118-20: PowerScheduleEntry, PriceRule and PriceLevelScheduleEntries. */
    @JsonProperty("maxScheduleTuples")
    private Integer maxScheduleTuples;

    @Min(0.0)

    @JsonProperty("chargingNeeds")
    private ChargingNeeds chargingNeeds;


    /** *(2.1)* Time when EV charging needs were received. + Field can be added when charging station was offline when charging needs were received. */
    @JsonProperty("timestamp")
    private String timestamp;


    @JsonProperty("customData")
    private CustomData customData;

}
