package com.example.demo.model.ocpp.schema.set_default_tariff_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class TariffFixed {


    @ElementCollection
    @Size(min = 1)
    @Column(name = "prices")
    private List<TariffFixedPrice> prices;

    @ElementCollection
    private List<TariffFixedPrice> prices = new ArrayList<>();


    @ElementCollection
    @Size(min = 1)
    @Size(max = 5)
    @Column(name = "tax_rates")
    private List<TaxRate> taxRates;

    @ElementCollection
    private List<TaxRate> taxRates = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
