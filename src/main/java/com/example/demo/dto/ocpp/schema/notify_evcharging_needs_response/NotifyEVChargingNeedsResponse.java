package com.example.demo.dto.ocpp.schema.notify_evcharging_needs_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class NotifyEVChargingNeedsResponse {


    @JsonProperty("status")
    private NotifyEVChargingNeedsStatusEnum status;


    @JsonProperty("statusInfo")
    private StatusInfo statusInfo;


    @JsonProperty("customData")
    private CustomData customData;

}
