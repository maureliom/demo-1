package com.example.demo.model.ocpp.schema.data_transfer_response;

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
@Table(name = "data_transfer_response")
public class DataTransferResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "status")
    private DataTransferStatusEnum status;


    @Column(name = "status_info")
    private StatusInfo statusInfo;


    /** Data without specified length or format, in response to request. */
    @Column(name = "data")
    private String data;


    @Column(name = "custom_data")
    private CustomData customData;

}
