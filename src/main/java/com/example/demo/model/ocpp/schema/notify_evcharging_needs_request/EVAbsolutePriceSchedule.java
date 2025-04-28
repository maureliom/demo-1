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
public class EVAbsolutePriceSchedule {


    /** Starting point in time of the EVEnergyOffer. */
    @Column(name = "time_anchor")
    private String timeAnchor;


    @Size(max = 3)
    /** Currency code according to ISO 4217. */
    @Column(name = "currency")
    private String currency;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 1024)
    @Column(name = "ev_absolute_price_schedule_entries")
    private List<EVAbsolutePriceScheduleEntry> evAbsolutePriceScheduleEntries;

    @ElementCollection
    private List<EVAbsolutePriceScheduleEntry> evAbsolutePriceScheduleEntries = new ArrayList<>();


    @Size(max = 2000)
    /** ISO 15118-20 URN of price algorithm: Power, PeakPower, StackedEnergy. */
    @Column(name = "price_algorithm")
    private String priceAlgorithm;


    @Column(name = "custom_data")
    private CustomData customData;

}
