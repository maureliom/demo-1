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
public class PriceLevelSchedule {


    @ElementCollection
    @Size(min = 1)
    @Size(max = 100)
    @Column(name = "price_level_schedule_entries")
    private List<PriceLevelScheduleEntry> priceLevelScheduleEntries;

    @ElementCollection
    private List<PriceLevelScheduleEntry> priceLevelScheduleEntries = new ArrayList<>();


    /** Starting point of this price schedule. */
    @Column(name = "time_anchor")
    private String timeAnchor;


    @Min(0)
    /** Unique ID of this price schedule. */
    @Column(name = "price_schedule_id")
    private Integer priceScheduleId;

    @Min(0.0)

    @Size(max = 32)
    /** Description of the price schedule. */
    @Column(name = "price_schedule_description")
    private String priceScheduleDescription;


    @Min(0)
    /** Defines the overall number of distinct price level elements used across all PriceLevelSchedules. */
    @Column(name = "number_of_price_levels")
    private Integer numberOfPriceLevels;

    @Min(0.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
