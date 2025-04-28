package com.example.demo.dto.ocpp.schema.request_battery_swap_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class RequestBatterySwapResponse {


    @JsonProperty("status")
    private GenericStatusEnum status;


    @JsonProperty("statusInfo")
    private StatusInfo statusInfo;


    @JsonProperty("customData")
    private CustomData customData;

}
