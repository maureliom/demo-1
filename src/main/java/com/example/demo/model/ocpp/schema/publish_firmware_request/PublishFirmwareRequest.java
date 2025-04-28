package com.example.demo.model.ocpp.schema.publish_firmware_request;

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
@Table(name = "publish_firmware_request")
public class PublishFirmwareRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Size(max = 2000)
    /** This contains a string containing a URI pointing to a location from which to retrieve the firmware. */
    @Column(name = "location")
    private String location;


    @Min(0)
    /** This specifies how many times Charging Station must retry to download the firmware before giving up. If this field is not present, it is left to Charging Station to decide how many times it wants to retry. If the value is 0, it means: no retries. */
    @Column(name = "retries")
    private Integer retries;

    @Min(0.0)

    @Size(max = 32)
    /** The MD5 checksum over the entire firmware file as a hexadecimal string of length 32. */
    @Column(name = "checksum")
    private String checksum;


    @Min(0)
    /** The Id of the request. */
    @Column(name = "request_id")
    private Integer requestId;

    @Min(0.0)

    @Min(0)
    /** The interval in seconds after which a retry may be attempted. If this field is not present, it is left to Charging Station to decide how long to wait between attempts. */
    @Column(name = "retry_interval")
    private Integer retryInterval;

    @Min(0.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
