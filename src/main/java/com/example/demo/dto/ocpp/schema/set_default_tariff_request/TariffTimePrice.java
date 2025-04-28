package com.example.demo.dto.ocpp.schema.set_default_tariff_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class TariffTimePrice {


    /** Price per minute (excl. tax) for this element. */
    @JsonProperty("priceMinute")
    private Double priceMinute;


    @JsonProperty("conditions")
    private TariffConditions conditions;


    @JsonProperty("customData")
    private CustomData customData;

}
