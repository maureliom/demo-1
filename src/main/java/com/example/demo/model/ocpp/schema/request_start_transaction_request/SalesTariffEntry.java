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
public class SalesTariffEntry {


    @Column(name = "relative_time_interval")
    private RelativeTimeInterval relativeTimeInterval;


    @Min(0)
    /** Defines the price level of this SalesTariffEntry (referring to NumEPriceLevels). Small values for the EPriceLevel represent a cheaper TariffEntry. Large values for the EPriceLevel represent a more expensive TariffEntry. */
    @Column(name = "e_price_level")
    private Integer ePriceLevel;

    @Min(0.0)

    @ElementCollection
    @Size(min = 1)
    @Size(max = 3)
    @Column(name = "consumption_cost")
    private List<ConsumptionCost> consumptionCost;

    @ElementCollection
    private List<ConsumptionCost> consumptionCost = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
