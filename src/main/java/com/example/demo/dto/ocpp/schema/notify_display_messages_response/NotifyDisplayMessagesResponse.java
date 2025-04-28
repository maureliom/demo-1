package com.example.demo.dto.ocpp.schema.notify_display_messages_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class NotifyDisplayMessagesResponse {


    @JsonProperty("customData")
    private CustomData customData;

}
