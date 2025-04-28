package com.example.demo.dto.ocpp.schema.authorize_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class Price {


    /** Price/cost excluding tax. Can be absent if _inclTax_ is present. */
    @JsonProperty("exclTax")
    private Double exclTax;


    /** Price/cost including tax. Can be absent if _exclTax_ is present. */
    @JsonProperty("inclTax")
    private Double inclTax;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 5)
    @JsonProperty("taxRates")
    private List<TaxRate> taxRates;

    @JsonProperty("taxRates")
    private List<TaxRate> taxRates = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
