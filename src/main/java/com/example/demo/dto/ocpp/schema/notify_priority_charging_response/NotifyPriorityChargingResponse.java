package com.example.demo.dto.ocpp.schema.notify_priority_charging_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class NotifyPriorityChargingResponse {


    @JsonProperty("customData")
    private CustomData customData;

}
