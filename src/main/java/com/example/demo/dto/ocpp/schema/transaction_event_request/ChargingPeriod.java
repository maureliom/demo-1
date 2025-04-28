package com.example.demo.dto.ocpp.schema.transaction_event_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ChargingPeriod {


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("dimensions")
    private List<CostDimension> dimensions;

    @JsonProperty("dimensions")
    private List<CostDimension> dimensions = new ArrayList<>();


    @Size(max = 60)
    /** Unique identifier of the Tariff that was used to calculate cost. If not provided, then cost was calculated by some other means. */
    @JsonProperty("tariffId")
    private String tariffId;


    /** Start timestamp of charging period. A period ends when the next period starts. The last period ends when the session ends. */
    @JsonProperty("startPeriod")
    private String startPeriod;


    @JsonProperty("customData")
    private CustomData customData;

}
