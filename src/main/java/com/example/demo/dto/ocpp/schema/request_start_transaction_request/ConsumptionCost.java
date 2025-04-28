package com.example.demo.dto.ocpp.schema.request_start_transaction_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ConsumptionCost {


    /** The lowest level of consumption that defines the starting point of this consumption block. The block interval extends to the start of the next interval. */
    @JsonProperty("startValue")
    private Double startValue;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 3)
    @JsonProperty("cost")
    private List<Cost> cost;

    @JsonProperty("cost")
    private List<Cost> cost = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
