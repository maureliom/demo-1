package com.example.demo.dto.ocpp.schema.notify_charging_limit_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class NotifyChargingLimitRequest {


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("chargingSchedule")
    private List<ChargingSchedule> chargingSchedule;

    @JsonProperty("chargingSchedule")
    private List<ChargingSchedule> chargingSchedule = new ArrayList<>();


    @Min(0)
    /** The EVSE to which the charging limit is set. If absent or when zero, it applies to the entire Charging Station. */
    @JsonProperty("evseId")
    private Integer evseId;

    @Min(0.0)

    @JsonProperty("chargingLimit")
    private ChargingLimit chargingLimit;


    @JsonProperty("customData")
    private CustomData customData;

}
