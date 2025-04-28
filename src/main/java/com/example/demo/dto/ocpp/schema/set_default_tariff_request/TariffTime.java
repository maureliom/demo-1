package com.example.demo.dto.ocpp.schema.set_default_tariff_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class TariffTime {


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("prices")
    private List<TariffTimePrice> prices;

    @JsonProperty("prices")
    private List<TariffTimePrice> prices = new ArrayList<>();


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
