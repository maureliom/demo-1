package com.example.demo.dto.ocpp.schema.boot_notification_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class BootNotificationResponse {


    /** This contains the CSMS’s current time. */
    @JsonProperty("currentTime")
    private String currentTime;


    /** When &lt;&lt;cmn_registrationstatusenumtype,Status&gt;&gt; is Accepted, this contains the heartbeat interval in seconds. If the CSMS returns something other than Accepted, the value of the interval field indicates the minimum wait time before sending a next BootNotification request. */
    @JsonProperty("interval")
    private Integer interval;


    @JsonProperty("status")
    private RegistrationStatusEnum status;


    @JsonProperty("statusInfo")
    private StatusInfo statusInfo;


    @JsonProperty("customData")
    private CustomData customData;

}
