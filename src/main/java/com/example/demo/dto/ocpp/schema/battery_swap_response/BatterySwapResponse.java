package com.example.demo.dto.ocpp.schema.battery_swap_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class BatterySwapResponse {


    @JsonProperty("customData")
    private CustomData customData;

}
