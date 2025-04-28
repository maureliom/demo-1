package com.example.demo.dto.ocpp.schema.firmware_status_notification_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class FirmwareStatusNotificationRequest {


    @JsonProperty("status")
    private FirmwareStatusEnum status;


    /** The request id that was provided in the UpdateFirmwareRequest that started this firmware update. This field is mandatory, unless the message was triggered by a TriggerMessageRequest AND there is no firmware update ongoing. */
    @JsonProperty("requestId")
    private Integer requestId;


    @JsonProperty("statusInfo")
    private StatusInfo statusInfo;


    @JsonProperty("customData")
    private CustomData customData;

}
