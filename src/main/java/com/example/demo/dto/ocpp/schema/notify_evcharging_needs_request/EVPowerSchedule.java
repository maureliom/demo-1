package com.example.demo.dto.ocpp.schema.notify_evcharging_needs_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class EVPowerSchedule {


    @ElementCollection
    @Size(min = 1)
    @Size(max = 1024)
    @JsonProperty("evPowerScheduleEntries")
    private List<EVPowerScheduleEntry> evPowerScheduleEntries;

    @JsonProperty("evPowerScheduleEntries")
    private List<EVPowerScheduleEntry> evPowerScheduleEntries = new ArrayList<>();


    /** The time that defines the starting point for the EVEnergyOffer. */
    @JsonProperty("timeAnchor")
    private String timeAnchor;


    @JsonProperty("customData")
    private CustomData customData;

}
