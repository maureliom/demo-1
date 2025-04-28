package com.example.demo.dto.ocpp.schema.battery_swap_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class BatterySwapRequest {


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("batteryData")
    private List<BatteryData> batteryData;

    @JsonProperty("batteryData")
    private List<BatteryData> batteryData = new ArrayList<>();


    @JsonProperty("eventType")
    private BatterySwapEventEnum eventType;


    @JsonProperty("idToken")
    private IdToken idToken;


    /** RequestId to correlate BatteryIn/Out events and optional RequestBatterySwapRequest. */
    @JsonProperty("requestId")
    private Integer requestId;


    @JsonProperty("customData")
    private CustomData customData;

}
