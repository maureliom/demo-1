package com.example.demo.model.ocpp.schema.notify_charging_limit_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class AbsolutePriceSchedule {


    /** Starting point of price schedule. */
    @Column(name = "time_anchor")
    private String timeAnchor;


    @Min(0)
    /** Unique ID of price schedule */
    @Column(name = "price_schedule_id")
    private Integer priceScheduleID;

    @Min(0.0)

    @Size(max = 160)
    /** Description of the price schedule. */
    @Column(name = "price_schedule_description")
    private String priceScheduleDescription;


    @Size(max = 3)
    /** Currency according to ISO 4217. */
    @Column(name = "currency")
    private String currency;


    @Size(max = 8)
    /** String that indicates what language is used for the human readable strings in the price schedule. Based on ISO 639. */
    @Column(name = "language")
    private String language;


    @Size(max = 2000)
    /** A string in URN notation which shall uniquely identify an algorithm that defines how to compute an energy fee sum for a specific power profile based on the EnergyFee information from the PriceRule elements. */
    @Column(name = "price_algorithm")
    private String priceAlgorithm;


    @Column(name = "minimum_cost")
    private RationalNumber minimumCost;


    @Column(name = "maximum_cost")
    private RationalNumber maximumCost;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 1024)
    @Column(name = "price_rule_stacks")
    private List<PriceRuleStack> priceRuleStacks;

    @ElementCollection
    private List<PriceRuleStack> priceRuleStacks = new ArrayList<>();


    @ElementCollection
    @Size(min = 1)
    @Size(max = 10)
    @Column(name = "tax_rules")
    private List<TaxRule> taxRules;

    @ElementCollection
    private List<TaxRule> taxRules = new ArrayList<>();


    @Column(name = "overstay_rule_list")
    private OverstayRuleList overstayRuleList;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 5)
    @Column(name = "additional_selected_services")
    private List<AdditionalSelectedServices> additionalSelectedServices;

    @ElementCollection
    private List<AdditionalSelectedServices> additionalSelectedServices = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
