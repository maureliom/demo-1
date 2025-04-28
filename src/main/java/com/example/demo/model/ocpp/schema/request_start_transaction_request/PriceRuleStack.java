package com.example.demo.model.ocpp.schema.request_start_transaction_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class PriceRuleStack {


    /** Duration of the stack of price rules. he amount of seconds that define the duration of the given PriceRule(s). */
    @Column(name = "duration")
    private Integer duration;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 8)
    @Column(name = "price_rule")
    private List<PriceRule> priceRule;

    @ElementCollection
    private List<PriceRule> priceRule = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
