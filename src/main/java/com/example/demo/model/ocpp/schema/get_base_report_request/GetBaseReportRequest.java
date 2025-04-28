package com.example.demo.model.ocpp.schema.get_base_report_request;

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
@Table(name = "get_base_report_request")
public class GetBaseReportRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    /** The Id of the request. */
    @Column(name = "request_id")
    private Integer requestId;


    @Column(name = "report_base")
    private ReportBaseEnum reportBase;


    @Column(name = "custom_data")
    private CustomData customData;

}
