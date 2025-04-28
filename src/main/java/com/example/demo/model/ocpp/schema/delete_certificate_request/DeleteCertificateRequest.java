package com.example.demo.model.ocpp.schema.delete_certificate_request;

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
@Table(name = "delete_certificate_request")
public class DeleteCertificateRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "certificate_hash_data")
    private CertificateHashData certificateHashData;


    @Column(name = "custom_data")
    private CustomData customData;

}
