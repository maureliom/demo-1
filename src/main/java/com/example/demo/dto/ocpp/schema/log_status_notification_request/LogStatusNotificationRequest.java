package com.example.demo.dto.ocpp.schema.log_status_notification_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class LogStatusNotificationRequest {


    @JsonProperty("status")
    private UploadLogStatusEnum status;


    /** The request id that was provided in GetLogRequest that started this log upload. This field is mandatory, unless the message was triggered by a TriggerMessageRequest AND there is no log upload ongoing. */
    @JsonProperty("requestId")
    private Integer requestId;


    @JsonProperty("statusInfo")
    private StatusInfo statusInfo;


    @JsonProperty("customData")
    private CustomData customData;

}
