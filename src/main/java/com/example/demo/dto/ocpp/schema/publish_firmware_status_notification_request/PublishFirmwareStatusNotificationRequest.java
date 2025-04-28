package com.example.demo.dto.ocpp.schema.publish_firmware_status_notification_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class PublishFirmwareStatusNotificationRequest {


    @JsonProperty("status")
    private PublishFirmwareStatusEnum status;


    @ElementCollection
    @Size(min = 1)
    /** Required if status is Published. Can be multiple URI’s, if the Local Controller supports e.g. HTTP, HTTPS, and FTP. */
    @JsonProperty("location")
    private List<String> location;

    @JsonProperty("location")
    private List<String> location = new ArrayList<>();


    @Min(0)
    /** The request id that was provided in the PublishFirmwareRequest which triggered this action. */
    @JsonProperty("requestId")
    private Integer requestId;

    @Min(0.0)

    @JsonProperty("statusInfo")
    private StatusInfo statusInfo;


    @JsonProperty("customData")
    private CustomData customData;

}
