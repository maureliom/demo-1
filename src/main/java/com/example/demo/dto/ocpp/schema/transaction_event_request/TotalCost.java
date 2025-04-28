package com.example.demo.dto.ocpp.schema.transaction_event_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class TotalCost {


    @Size(max = 3)
    /** Currency of the costs in ISO 4217 Code. */
    @JsonProperty("currency")
    private String currency;


    @JsonProperty("typeOfCost")
    private TariffCostEnum typeOfCost;


    @JsonProperty("fixed")
    private Price fixed;


    @JsonProperty("energy")
    private Price energy;


    @JsonProperty("chargingTime")
    private Price chargingTime;


    @JsonProperty("idleTime")
    private Price idleTime;


    @JsonProperty("reservationTime")
    private Price reservationTime;


    @JsonProperty("reservationFixed")
    private Price reservationFixed;


    @JsonProperty("total")
    private TotalPrice total;


    @JsonProperty("customData")
    private CustomData customData;

}
