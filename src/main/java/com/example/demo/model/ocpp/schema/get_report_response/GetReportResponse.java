package com.example.demo.model.ocpp.schema.get_report_response;

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
@Table(name = "get_report_response")
public class GetReportResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "status")
    private GenericDeviceModelStatusEnum status;


    @Column(name = "status_info")
    private StatusInfo statusInfo;


    @Column(name = "custom_data")
    private CustomData customData;

}
