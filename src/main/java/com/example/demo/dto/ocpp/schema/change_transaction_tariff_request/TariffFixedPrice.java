package com.example.demo.dto.ocpp.schema.change_transaction_tariff_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class TariffFixedPrice {


    @JsonProperty("conditions")
    private TariffConditionsFixed conditions;


    /** Fixed price for this element e.g. a start fee. */
    @JsonProperty("priceFixed")
    private Double priceFixed;


    @JsonProperty("customData")
    private CustomData customData;

}
