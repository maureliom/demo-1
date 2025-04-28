package com.example.demo.dto.ocpp.schema.notify_evcharging_needs_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class EVAbsolutePriceSchedule {


    /** Starting point in time of the EVEnergyOffer. */
    @JsonProperty("timeAnchor")
    private String timeAnchor;


    @Size(max = 3)
    /** Currency code according to ISO 4217. */
    @JsonProperty("currency")
    private String currency;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 1024)
    @JsonProperty("evAbsolutePriceScheduleEntries")
    private List<EVAbsolutePriceScheduleEntry> evAbsolutePriceScheduleEntries;

    @JsonProperty("evAbsolutePriceScheduleEntries")
    private List<EVAbsolutePriceScheduleEntry> evAbsolutePriceScheduleEntries = new ArrayList<>();


    @Size(max = 2000)
    /** ISO 15118-20 URN of price algorithm: Power, PeakPower, StackedEnergy. */
    @JsonProperty("priceAlgorithm")
    private String priceAlgorithm;


    @JsonProperty("customData")
    private CustomData customData;

}
