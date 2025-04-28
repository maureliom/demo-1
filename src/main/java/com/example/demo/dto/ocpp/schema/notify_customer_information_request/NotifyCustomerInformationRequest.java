package com.example.demo.dto.ocpp.schema.notify_customer_information_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class NotifyCustomerInformationRequest {


    @Size(max = 512)
    /** (Part of) the requested data. No format specified in which the data is returned. Should be human readable. */
    @JsonProperty("data")
    private String data;


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


    @Min(0)
    /** The Id of the request. */
    @JsonProperty("requestId")
    private Integer requestId;

    @Min(0.0)

    @JsonProperty("customData")
    private CustomData customData;

}
