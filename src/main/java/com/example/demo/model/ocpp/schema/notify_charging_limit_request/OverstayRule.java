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
public class OverstayRule {


    @Column(name = "overstay_fee")
    private RationalNumber overstayFee;


    @Size(max = 32)
    /** Human readable string to identify the overstay rule. */
    @Column(name = "overstay_rule_description")
    private String overstayRuleDescription;


    /** Time in seconds after trigger of the parent Overstay Rules for this particular fee to apply. */
    @Column(name = "start_time")
    private Integer startTime;


    /** Time till overstay will be reapplied */
    @Column(name = "overstay_fee_period")
    private Integer overstayFeePeriod;


    @Column(name = "custom_data")
    private CustomData customData;

}
