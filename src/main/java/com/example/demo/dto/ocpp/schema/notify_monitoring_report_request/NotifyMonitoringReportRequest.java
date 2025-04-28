package com.example.demo.dto.ocpp.schema.notify_monitoring_report_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class NotifyMonitoringReportRequest {


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("monitor")
    private List<MonitoringData> monitor;

    @JsonProperty("monitor")
    private List<MonitoringData> monitor = new ArrayList<>();


    /** The id of the GetMonitoringRequest that requested this report. */
    @JsonProperty("requestId")
    private Integer requestId;


    /** “to be continued” indicator. Indicates whether another part of the monitoringData follows in an upcoming notifyMonitoringReportRequest message. Default value when omitted is false. */
    @JsonProperty("tbc")
    private Boolean tbc;


    @Min(0)
    /** Sequence number of this message. First message starts at 0. */
    @JsonProperty("seqNo")
    private Integer seqNo;

    @Min(0.0)

    /** Timestamp of the moment this message was generated at the Charging Station. */
    @JsonProperty("generatedAt")
    private String generatedAt;


    @JsonProperty("customData")
    private CustomData customData;

}
