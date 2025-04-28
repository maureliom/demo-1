package com.example.demo.dto.ocpp.schema.notify_evcharging_needs_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class EVPowerScheduleEntry {


    /** The duration of this entry. */
    @JsonProperty("duration")
    private Integer duration;


    /** Defines maximum amount of power for the duration of this EVPowerScheduleEntry to be discharged from the EV battery through EVSE power outlet. Negative values are used for discharging. */
    @JsonProperty("power")
    private Double power;


    @JsonProperty("customData")
    private CustomData customData;

}
