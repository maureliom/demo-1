package com.example.demo.model.ocpp.schema.update_firmware_request;

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
@Table(name = "update_firmware_request")
public class UpdateFirmwareRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Min(0)
    /** This specifies how many times Charging Station must retry to download the firmware before giving up. If this field is not present, it is left to Charging Station to decide how many times it wants to retry. If the value is 0, it means: no retries. */
    @Column(name = "retries")
    private Integer retries;

    @Min(0.0)

    /** The interval in seconds after which a retry may be attempted. If this field is not present, it is left to Charging Station to decide how long to wait between attempts. */
    @Column(name = "retry_interval")
    private Integer retryInterval;


    /** The Id of this request */
    @Column(name = "request_id")
    private Integer requestId;


    @Column(name = "firmware")
    private Firmware firmware;


    @Column(name = "custom_data")
    private CustomData customData;

}
