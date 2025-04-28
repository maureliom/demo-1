package com.example.demo.dto.ocpp.schema.set_charging_profile_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class AbsolutePriceSchedule {


    /** Starting point of price schedule. */
    @JsonProperty("timeAnchor")
    private String timeAnchor;


    @Min(0)
    /** Unique ID of price schedule */
    @JsonProperty("priceScheduleID")
    private Integer priceScheduleID;

    @Min(0.0)

    @Size(max = 160)
    /** Description of the price schedule. */
    @JsonProperty("priceScheduleDescription")
    private String priceScheduleDescription;


    @Size(max = 3)
    /** Currency according to ISO 4217. */
    @JsonProperty("currency")
    private String currency;


    @Size(max = 8)
    /** String that indicates what language is used for the human readable strings in the price schedule. Based on ISO 639. */
    @JsonProperty("language")
    private String language;


    @Size(max = 2000)
    /** A string in URN notation which shall uniquely identify an algorithm that defines how to compute an energy fee sum for a specific power profile based on the EnergyFee information from the PriceRule elements. */
    @JsonProperty("priceAlgorithm")
    private String priceAlgorithm;


    @JsonProperty("minimumCost")
    private RationalNumber minimumCost;


    @JsonProperty("maximumCost")
    private RationalNumber maximumCost;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 1024)
    @JsonProperty("priceRuleStacks")
    private List<PriceRuleStack> priceRuleStacks;

    @JsonProperty("priceRuleStacks")
    private List<PriceRuleStack> priceRuleStacks = new ArrayList<>();


    @ElementCollection
    @Size(min = 1)
    @Size(max = 10)
    @JsonProperty("taxRules")
    private List<TaxRule> taxRules;

    @JsonProperty("taxRules")
    private List<TaxRule> taxRules = new ArrayList<>();


    @JsonProperty("overstayRuleList")
    private OverstayRuleList overstayRuleList;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 5)
    @JsonProperty("additionalSelectedServices")
    private List<AdditionalSelectedServices> additionalSelectedServices;

    @JsonProperty("additionalSelectedServices")
    private List<AdditionalSelectedServices> additionalSelectedServices = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
