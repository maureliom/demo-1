package com.example.demo.dto.ocpp.schema.notify_evcharging_schedule_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class SalesTariffEntry {


    @JsonProperty("relativeTimeInterval")
    private RelativeTimeInterval relativeTimeInterval;


    @Min(0)
    /** Defines the price level of this SalesTariffEntry (referring to NumEPriceLevels). Small values for the EPriceLevel represent a cheaper TariffEntry. Large values for the EPriceLevel represent a more expensive TariffEntry. */
    @JsonProperty("ePriceLevel")
    private Integer ePriceLevel;

    @Min(0.0)

    @ElementCollection
    @Size(min = 1)
    @Size(max = 3)
    @JsonProperty("consumptionCost")
    private List<ConsumptionCost> consumptionCost;

    @JsonProperty("consumptionCost")
    private List<ConsumptionCost> consumptionCost = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
