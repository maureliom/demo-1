package com.example.demo.dto.ocpp.schema.request_battery_swap_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class RequestBatterySwapRequest {


    @JsonProperty("idToken")
    private IdToken idToken;


    /** Request id to match with BatterySwapRequest. */
    @JsonProperty("requestId")
    private Integer requestId;


    @JsonProperty("customData")
    private CustomData customData;

}
