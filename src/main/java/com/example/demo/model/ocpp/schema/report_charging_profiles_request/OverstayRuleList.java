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
public class OverstayRuleList {


    @Column(name = "overstay_power_threshold")
    private RationalNumber overstayPowerThreshold;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 5)
    @Column(name = "overstay_rule")
    private List<OverstayRule> overstayRule;

    @ElementCollection
    private List<OverstayRule> overstayRule = new ArrayList<>();


    /** Time till overstay is applied in seconds. */
    @Column(name = "overstay_time_threshold")
    private Integer overstayTimeThreshold;


    @Column(name = "custom_data")
    private CustomData customData;

}
