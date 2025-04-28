package com.example.demo.model.ocpp.schema.get_certificate_status_request;

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
@Table(name = "get_certificate_status_request")
public class GetCertificateStatusRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "ocsp_request_data")
    private OCSPRequestData ocspRequestData;


    @Column(name = "custom_data")
    private CustomData customData;

}
