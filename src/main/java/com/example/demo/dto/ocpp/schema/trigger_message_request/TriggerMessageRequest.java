package com.example.demo.dto.ocpp.schema.trigger_message_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class TriggerMessageRequest {


    @JsonProperty("evse")
    private EVSE evse;


    @JsonProperty("requestedMessage")
    private MessageTriggerEnum requestedMessage;


    @Size(max = 50)
    /** *(2.1)* When _requestedMessage_ = `CustomTrigger` this will trigger sending the corresponding message in field _customTrigger_, if supported by Charging Station. */
    @JsonProperty("customTrigger")
    private String customTrigger;


    @JsonProperty("customData")
    private CustomData customData;

}
