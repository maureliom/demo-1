package com.example.demo.dto.ocpp.schema.notify_evcharging_needs_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class EVAbsolutePriceScheduleEntry {


    /** The amount of seconds of this entry. */
    @JsonProperty("duration")
    private Integer duration;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 8)
    @JsonProperty("evPriceRule")
    private List<EVPriceRule> evPriceRule;

    @JsonProperty("evPriceRule")
    private List<EVPriceRule> evPriceRule = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
