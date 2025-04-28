package com.example.demo.model.ocpp.schema.notify_customer_information_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "notify_customer_information_request")
public class NotifyCustomerInformationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Size(max = 512)
    /** (Part of) the requested data. No format specified in which the data is returned. Should be human readable. */
    @Column(name = "data")
    private String data;


    /** “to be continued” indicator. Indicates whether another part of the monitoringData follows in an upcoming notifyMonitoringReportRequest message. Default value when omitted is false. */
    @Column(name = "tbc")
    private Boolean tbc;


    @Min(0)
    /** Sequence number of this message. First message starts at 0. */
    @Column(name = "seq_no")
    private Integer seqNo;

    @Min(0.0)

    /** Timestamp of the moment this message was generated at the Charging Station. */
    @Column(name = "generated_at")
    private String generatedAt;


    @Min(0)
    /** The Id of the request. */
    @Column(name = "request_id")
    private Integer requestId;

    @Min(0.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
