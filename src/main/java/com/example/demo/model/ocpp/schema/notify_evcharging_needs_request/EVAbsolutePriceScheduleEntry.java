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
public class EVAbsolutePriceScheduleEntry {


    /** The amount of seconds of this entry. */
    @Column(name = "duration")
    private Integer duration;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 8)
    @Column(name = "ev_price_rule")
    private List<EVPriceRule> evPriceRule;

    @ElementCollection
    private List<EVPriceRule> evPriceRule = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
