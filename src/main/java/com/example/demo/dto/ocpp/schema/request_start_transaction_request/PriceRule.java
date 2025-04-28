package com.example.demo.dto.ocpp.schema.request_start_transaction_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class PriceRule {


    /** The duration of the parking fee period (in seconds). When the time enters into a ParkingFeePeriod, the ParkingFee will apply to the session. . */
    @JsonProperty("parkingFeePeriod")
    private Integer parkingFeePeriod;


    @Min(0)
    /** Number of grams of CO2 per kWh. */
    @JsonProperty("carbonDioxideEmission")
    private Integer carbonDioxideEmission;

    @Min(0.0)

    @Min(0)
    @Max(100)
    /** Percentage of the power that is created by renewable resources. */
    @JsonProperty("renewableGenerationPercentage")
    private Integer renewableGenerationPercentage;

    @Min(0.0)
    @Max(100.0)

    @JsonProperty("energyFee")
    private RationalNumber energyFee;


    @JsonProperty("parkingFee")
    private RationalNumber parkingFee;


    @JsonProperty("powerRangeStart")
    private RationalNumber powerRangeStart;


    @JsonProperty("customData")
    private CustomData customData;

}
