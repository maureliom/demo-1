package com.example.demo.dto.ocpp.schema.notify_priority_charging_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class NotifyPriorityChargingRequest {


    @Size(max = 36)
    /** The transaction for which priority charging is requested. */
    @JsonProperty("transactionId")
    private String transactionId;


    /** True if priority charging was activated. False if it has stopped using the priority charging profile. */
    @JsonProperty("activated")
    private Boolean activated;


    @JsonProperty("customData")
    private CustomData customData;

}
