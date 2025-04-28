package com.example.demo.dto.ocpp.schema.notify_report_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class NotifyReportRequest {


    /** The id of the GetReportRequest or GetBaseReportRequest that requested this report */
    @JsonProperty("requestId")
    private Integer requestId;


    /** Timestamp of the moment this message was generated at the Charging Station. */
    @JsonProperty("generatedAt")
    private String generatedAt;


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("reportData")
    private List<ReportData> reportData;

    @JsonProperty("reportData")
    private List<ReportData> reportData = new ArrayList<>();


    /** “to be continued” indicator. Indicates whether another part of the report follows in an upcoming notifyReportRequest message. Default value when omitted is false. */
    @JsonProperty("tbc")
    private Boolean tbc;


    @Min(0)
    /** Sequence number of this message. First message starts at 0. */
    @JsonProperty("seqNo")
    private Integer seqNo;

    @Min(0.0)

    @JsonProperty("customData")
    private CustomData customData;

}
