package com.example.demo.dto.ocpp.schema.transaction_event_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class TransactionLimit {


    /** Maximum allowed cost of transaction in currency of tariff. */
    @JsonProperty("maxCost")
    private Double maxCost;


    /** Maximum allowed energy in Wh to charge in transaction. */
    @JsonProperty("maxEnergy")
    private Double maxEnergy;


    /** Maximum duration of transaction in seconds from start to end. */
    @JsonProperty("maxTime")
    private Integer maxTime;


    @Min(0)
    @Max(100)
    /** Maximum State of Charge of EV in percentage. */
    @JsonProperty("maxSoC")
    private Integer maxSoC;

    @Min(0.0)
    @Max(100.0)

    @JsonProperty("customData")
    private CustomData customData;

}
