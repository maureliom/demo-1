package com.example.demo.model.ocpp.schema.set_charging_profile_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class Cost {


    @Column(name = "cost_kind")
    private CostKindEnum costKind;


    /** The estimated or actual cost per kWh */
    @Column(name = "amount")
    private Integer amount;


    /** Values: -3..3, The amountMultiplier defines the exponent to base 10 (dec). The final value is determined by: amount * 10 ^ amountMultiplier */
    @Column(name = "amount_multiplier")
    private Integer amountMultiplier;


    @Column(name = "custom_data")
    private CustomData customData;

}
