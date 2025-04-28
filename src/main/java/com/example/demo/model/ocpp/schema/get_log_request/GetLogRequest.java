package com.example.demo.model.ocpp.schema.get_log_request;

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
@Table(name = "get_log_request")
public class GetLogRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "log")
    private LogParameters log;


    @Column(name = "log_type")
    private LogEnum logType;


    /** The Id of this request */
    @Column(name = "request_id")
    private Integer requestId;


    @Min(0)
    /** This specifies how many times the Charging Station must retry to upload the log before giving up. If this field is not present, it is left to Charging Station to decide how many times it wants to retry. If the value is 0, it means: no retries. */
    @Column(name = "retries")
    private Integer retries;

    @Min(0.0)

    /** The interval in seconds after which a retry may be attempted. If this field is not present, it is left to Charging Station to decide how long to wait between attempts. */
    @Column(name = "retry_interval")
    private Integer retryInterval;


    @Column(name = "custom_data")
    private CustomData customData;

}
