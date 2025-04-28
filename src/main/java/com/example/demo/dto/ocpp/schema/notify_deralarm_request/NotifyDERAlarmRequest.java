package com.example.demo.dto.ocpp.schema.notify_deralarm_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class NotifyDERAlarmRequest {


    @JsonProperty("controlType")
    private DERControlEnum controlType;


    @JsonProperty("gridEventFault")
    private GridEventFaultEnum gridEventFault;


    /** True when error condition has ended. Absent or false when alarm has started. */
    @JsonProperty("alarmEnded")
    private Boolean alarmEnded;


    /** Time of start or end of alarm. */
    @JsonProperty("timestamp")
    private String timestamp;


    @Size(max = 200)
    /** Optional info provided by EV. */
    @JsonProperty("extraInfo")
    private String extraInfo;


    @JsonProperty("customData")
    private CustomData customData;

}
