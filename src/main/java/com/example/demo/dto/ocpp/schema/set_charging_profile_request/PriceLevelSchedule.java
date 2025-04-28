package com.example.demo.dto.ocpp.schema.set_charging_profile_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class PriceLevelSchedule {


    @ElementCollection
    @Size(min = 1)
    @Size(max = 100)
    @JsonProperty("priceLevelScheduleEntries")
    private List<PriceLevelScheduleEntry> priceLevelScheduleEntries;

    @JsonProperty("priceLevelScheduleEntries")
    private List<PriceLevelScheduleEntry> priceLevelScheduleEntries = new ArrayList<>();


    /** Starting point of this price schedule. */
    @JsonProperty("timeAnchor")
    private String timeAnchor;


    @Min(0)
    /** Unique ID of this price schedule. */
    @JsonProperty("priceScheduleId")
    private Integer priceScheduleId;

    @Min(0.0)

    @Size(max = 32)
    /** Description of the price schedule. */
    @JsonProperty("priceScheduleDescription")
    private String priceScheduleDescription;


    @Min(0)
    /** Defines the overall number of distinct price level elements used across all PriceLevelSchedules. */
    @JsonProperty("numberOfPriceLevels")
    private Integer numberOfPriceLevels;

    @Min(0.0)

    @JsonProperty("customData")
    private CustomData customData;

}
