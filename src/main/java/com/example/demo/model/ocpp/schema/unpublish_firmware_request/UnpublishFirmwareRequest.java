package com.example.demo.model.ocpp.schema.unpublish_firmware_request;

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
@Table(name = "unpublish_firmware_request")
public class UnpublishFirmwareRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Size(max = 32)
    /** The MD5 checksum over the entire firmware file as a hexadecimal string of length 32. */
    @Column(name = "checksum")
    private String checksum;


    @Column(name = "custom_data")
    private CustomData customData;

}
