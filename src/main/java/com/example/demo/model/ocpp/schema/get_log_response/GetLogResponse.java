package com.example.demo.model.ocpp.schema.get_log_response;

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
@Table(name = "get_log_response")
public class GetLogResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "status")
    private LogStatusEnum status;


    @Column(name = "status_info")
    private StatusInfo statusInfo;


    @Size(max = 255)
    /** This contains the name of the log file that will be uploaded. This field is not present when no logging information is available. */
    @Column(name = "filename")
    private String filename;


    @Column(name = "custom_data")
    private CustomData customData;

}
