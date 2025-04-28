package com.example.demo.model.ocpp.schema.notify_monitoring_report_request;

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
@Table(name = "notify_monitoring_report_request")
public class NotifyMonitoringReportRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @ElementCollection
    @Size(min = 1)
    @Column(name = "monitor")
    private List<MonitoringData> monitor;

    @ElementCollection
    private List<MonitoringData> monitor = new ArrayList<>();


    /** The id of the GetMonitoringRequest that requested this report. */
    @Column(name = "request_id")
    private Integer requestId;


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


    @Column(name = "custom_data")
    private CustomData customData;

}
