package com.example.demo.dto.ocpp.schema.notify_evcharging_schedule_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class PriceRuleStack {


    /** Duration of the stack of price rules. he amount of seconds that define the duration of the given PriceRule(s). */
    @JsonProperty("duration")
    private Integer duration;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 8)
    @JsonProperty("priceRule")
    private List<PriceRule> priceRule;

    @JsonProperty("priceRule")
    private List<PriceRule> priceRule = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
