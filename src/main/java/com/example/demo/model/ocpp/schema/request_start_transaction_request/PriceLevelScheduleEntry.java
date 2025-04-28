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
public class PriceLevelScheduleEntry {


    /** The amount of seconds that define the duration of this given PriceLevelScheduleEntry. */
    @Column(name = "duration")
    private Integer duration;


    @Min(0)
    /** Defines the price level of this PriceLevelScheduleEntry (referring to NumberOfPriceLevels). Small values for the PriceLevel represent a cheaper PriceLevelScheduleEntry. Large values for the PriceLevel represent a more expensive PriceLevelScheduleEntry. */
    @Column(name = "price_level")
    private Integer priceLevel;

    @Min(0.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
