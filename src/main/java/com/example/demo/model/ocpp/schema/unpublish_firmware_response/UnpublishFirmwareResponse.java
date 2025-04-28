package com.example.demo.model.ocpp.schema.unpublish_firmware_response;

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
@Table(name = "unpublish_firmware_response")
public class UnpublishFirmwareResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "status")
    private UnpublishFirmwareStatusEnum status;


    @Column(name = "custom_data")
    private CustomData customData;

}
