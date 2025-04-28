package com.example.demo.dto.ocpp.schema.use_priority_charging_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class UsePriorityChargingRequest {


    @Size(max = 36)
    /** The transaction for which priority charging is requested. */
    @JsonProperty("transactionId")
    private String transactionId;


    /** True to request priority charging. False to request stopping priority charging. */
    @JsonProperty("activate")
    private Boolean activate;


    @JsonProperty("customData")
    private CustomData customData;

}
