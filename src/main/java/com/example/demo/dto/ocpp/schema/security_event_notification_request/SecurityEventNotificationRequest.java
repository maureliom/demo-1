package com.example.demo.dto.ocpp.schema.security_event_notification_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class SecurityEventNotificationRequest {


    @Size(max = 50)
    /** Type of the security event. This value should be taken from the Security events list. */
    @JsonProperty("type")
    private String type;


    /** Date and time at which the event occurred. */
    @JsonProperty("timestamp")
    private String timestamp;


    @Size(max = 255)
    /** Additional information about the occurred security event. */
    @JsonProperty("techInfo")
    private String techInfo;


    @JsonProperty("customData")
    private CustomData customData;

}
