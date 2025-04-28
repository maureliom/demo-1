package com.example.demo.dto.ocpp.schema.set_display_message_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class SetDisplayMessageRequest {


    @JsonProperty("message")
    private MessageInfo message;


    @JsonProperty("customData")
    private CustomData customData;

}
