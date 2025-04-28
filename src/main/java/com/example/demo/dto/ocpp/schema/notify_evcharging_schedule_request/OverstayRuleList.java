package com.example.demo.dto.ocpp.schema.notify_evcharging_schedule_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class OverstayRuleList {


    @JsonProperty("overstayPowerThreshold")
    private RationalNumber overstayPowerThreshold;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 5)
    @JsonProperty("overstayRule")
    private List<OverstayRule> overstayRule;

    @JsonProperty("overstayRule")
    private List<OverstayRule> overstayRule = new ArrayList<>();


    /** Time till overstay is applied in seconds. */
    @JsonProperty("overstayTimeThreshold")
    private Integer overstayTimeThreshold;


    @JsonProperty("customData")
    private CustomData customData;

}
