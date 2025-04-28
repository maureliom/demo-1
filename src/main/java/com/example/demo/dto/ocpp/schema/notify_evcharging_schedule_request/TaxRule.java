package com.example.demo.dto.ocpp.schema.notify_evcharging_schedule_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class TaxRule {


    @Min(0)
    /** Id for the tax rule. */
    @JsonProperty("taxRuleID")
    private Integer taxRuleID;

    @Min(0.0)

    @Size(max = 100)
    /** Human readable string to identify the tax rule. */
    @JsonProperty("taxRuleName")
    private String taxRuleName;


    /** Indicates whether the tax is included in any price or not. */
    @JsonProperty("taxIncludedInPrice")
    private Boolean taxIncludedInPrice;


    /** Indicates whether this tax applies to Energy Fees. */
    @JsonProperty("appliesToEnergyFee")
    private Boolean appliesToEnergyFee;


    /** Indicates whether this tax applies to Parking Fees. */
    @JsonProperty("appliesToParkingFee")
    private Boolean appliesToParkingFee;


    /** Indicates whether this tax applies to Overstay Fees. */
    @JsonProperty("appliesToOverstayFee")
    private Boolean appliesToOverstayFee;


    /** Indicates whether this tax applies to Minimum/Maximum Cost. */
    @JsonProperty("appliesToMinimumMaximumCost")
    private Boolean appliesToMinimumMaximumCost;


    @JsonProperty("taxRate")
    private RationalNumber taxRate;


    @JsonProperty("customData")
    private CustomData customData;

}
