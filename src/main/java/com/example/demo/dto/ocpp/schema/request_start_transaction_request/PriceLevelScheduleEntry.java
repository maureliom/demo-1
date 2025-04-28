package com.example.demo.dto.ocpp.schema.request_start_transaction_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class PriceLevelScheduleEntry {


    /** The amount of seconds that define the duration of this given PriceLevelScheduleEntry. */
    @JsonProperty("duration")
    private Integer duration;


    @Min(0)
    /** Defines the price level of this PriceLevelScheduleEntry (referring to NumberOfPriceLevels). Small values for the PriceLevel represent a cheaper PriceLevelScheduleEntry. Large values for the PriceLevel represent a more expensive PriceLevelScheduleEntry. */
    @JsonProperty("priceLevel")
    private Integer priceLevel;

    @Min(0.0)

    @JsonProperty("customData")
    private CustomData customData;

}
