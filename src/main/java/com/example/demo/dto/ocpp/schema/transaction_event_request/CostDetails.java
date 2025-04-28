package com.example.demo.dto.ocpp.schema.transaction_event_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class CostDetails {


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("chargingPeriods")
    private List<ChargingPeriod> chargingPeriods;

    @JsonProperty("chargingPeriods")
    private List<ChargingPeriod> chargingPeriods = new ArrayList<>();


    @JsonProperty("totalCost")
    private TotalCost totalCost;


    @JsonProperty("totalUsage")
    private TotalUsage totalUsage;


    /** If set to true, then Charging Station has failed to calculate the cost. */
    @JsonProperty("failureToCalculate")
    private Boolean failureToCalculate;


    @Size(max = 500)
    /** Optional human-readable reason text in case of failure to calculate. */
    @JsonProperty("failureReason")
    private String failureReason;


    @JsonProperty("customData")
    private CustomData customData;

}
