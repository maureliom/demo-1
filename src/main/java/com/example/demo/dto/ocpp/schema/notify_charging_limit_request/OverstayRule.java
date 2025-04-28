package com.example.demo.dto.ocpp.schema.notify_charging_limit_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class OverstayRule {


    @JsonProperty("overstayFee")
    private RationalNumber overstayFee;


    @Size(max = 32)
    /** Human readable string to identify the overstay rule. */
    @JsonProperty("overstayRuleDescription")
    private String overstayRuleDescription;


    /** Time in seconds after trigger of the parent Overstay Rules for this particular fee to apply. */
    @JsonProperty("startTime")
    private Integer startTime;


    /** Time till overstay will be reapplied */
    @JsonProperty("overstayFeePeriod")
    private Integer overstayFeePeriod;


    @JsonProperty("customData")
    private CustomData customData;

}
