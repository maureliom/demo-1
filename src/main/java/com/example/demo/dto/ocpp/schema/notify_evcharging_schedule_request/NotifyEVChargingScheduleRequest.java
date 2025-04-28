package com.example.demo.dto.ocpp.schema.notify_evcharging_schedule_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class NotifyEVChargingScheduleRequest {


    /** Periods contained in the charging profile are relative to this point in time. */
    @JsonProperty("timeBase")
    private String timeBase;


    @JsonProperty("chargingSchedule")
    private ChargingSchedule chargingSchedule;


    @Min(1)
    /** The charging schedule contained in this notification applies to an EVSE. EvseId must be &gt; 0. */
    @JsonProperty("evseId")
    private Integer evseId;

    @Min(1.0)

    @Min(0)
    /** *(2.1)* Id of the _chargingSchedule_ that EV selected from the provided ChargingProfile. */
    @JsonProperty("selectedChargingScheduleId")
    private Integer selectedChargingScheduleId;

    @Min(0.0)

    /** *(2.1)* True when power tolerance is accepted by EV. This value is taken from EVPowerProfile.PowerToleranceAcceptance in the ISO 15118-20 PowerDeliverReq message.. */
    @JsonProperty("powerToleranceAcceptance")
    private Boolean powerToleranceAcceptance;


    @JsonProperty("customData")
    private CustomData customData;

}
