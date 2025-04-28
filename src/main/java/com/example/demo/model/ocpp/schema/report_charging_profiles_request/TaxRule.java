package com.example.demo.model.ocpp.schema.report_charging_profiles_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class TaxRule {


    @Min(0)
    /** Id for the tax rule. */
    @Column(name = "tax_rule_id")
    private Integer taxRuleID;

    @Min(0.0)

    @Size(max = 100)
    /** Human readable string to identify the tax rule. */
    @Column(name = "tax_rule_name")
    private String taxRuleName;


    /** Indicates whether the tax is included in any price or not. */
    @Column(name = "tax_included_in_price")
    private Boolean taxIncludedInPrice;


    /** Indicates whether this tax applies to Energy Fees. */
    @Column(name = "applies_to_energy_fee")
    private Boolean appliesToEnergyFee;


    /** Indicates whether this tax applies to Parking Fees. */
    @Column(name = "applies_to_parking_fee")
    private Boolean appliesToParkingFee;


    /** Indicates whether this tax applies to Overstay Fees. */
    @Column(name = "applies_to_overstay_fee")
    private Boolean appliesToOverstayFee;


    /** Indicates whether this tax applies to Minimum/Maximum Cost. */
    @Column(name = "applies_to_minimum_maximum_cost")
    private Boolean appliesToMinimumMaximumCost;


    @Column(name = "tax_rate")
    private RationalNumber taxRate;


    @Column(name = "custom_data")
    private CustomData customData;

}
