package com.example.demo.dto.ocpp.schema.report_charging_profiles_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class Cost {


    @JsonProperty("costKind")
    private CostKindEnum costKind;


    /** The estimated or actual cost per kWh */
    @JsonProperty("amount")
    private Integer amount;


    /** Values: -3..3, The amountMultiplier defines the exponent to base 10 (dec). The final value is determined by: amount * 10 ^ amountMultiplier */
    @JsonProperty("amountMultiplier")
    private Integer amountMultiplier;


    @JsonProperty("customData")
    private CustomData customData;

}
