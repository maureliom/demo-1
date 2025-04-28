package com.example.demo.dto.ocpp.schema.authorize_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class TariffEnergyPrice {


    /** Price per kWh (excl. tax) for this element. */
    @JsonProperty("priceKwh")
    private Double priceKwh;


    @JsonProperty("conditions")
    private TariffConditions conditions;


    @JsonProperty("customData")
    private CustomData customData;

}
