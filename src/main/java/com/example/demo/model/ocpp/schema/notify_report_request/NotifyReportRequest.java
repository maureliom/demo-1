package com.example.demo.model.ocpp.schema.notify_report_request;

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
@Table(name = "notify_report_request")
public class NotifyReportRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    /** The id of the GetReportRequest or GetBaseReportRequest that requested this report */
    @Column(name = "request_id")
    private Integer requestId;


    /** Timestamp of the moment this message was generated at the Charging Station. */
    @Column(name = "generated_at")
    private String generatedAt;


    @ElementCollection
    @Size(min = 1)
    @Column(name = "report_data")
    private List<ReportData> reportData;

    @ElementCollection
    private List<ReportData> reportData = new ArrayList<>();


    /** “to be continued” indicator. Indicates whether another part of the report follows in an upcoming notifyReportRequest message. Default value when omitted is false. */
    @Column(name = "tbc")
    private Boolean tbc;


    @Min(0)
    /** Sequence number of this message. First message starts at 0. */
    @Column(name = "seq_no")
    private Integer seqNo;

    @Min(0.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
