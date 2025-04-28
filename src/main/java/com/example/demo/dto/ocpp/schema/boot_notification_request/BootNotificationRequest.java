package com.example.demo.dto.ocpp.schema.boot_notification_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class BootNotificationRequest {


    @JsonProperty("chargingStation")
    private ChargingStation chargingStation;


    @JsonProperty("reason")
    private BootReasonEnum reason;


    @JsonProperty("customData")
    private CustomData customData;

}
