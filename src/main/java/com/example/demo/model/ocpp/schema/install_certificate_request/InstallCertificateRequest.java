package com.example.demo.model.ocpp.schema.install_certificate_request;

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
@Table(name = "install_certificate_request")
public class InstallCertificateRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "certificate_type")
    private InstallCertificateUseEnum certificateType;


    @Size(max = 10000)
    /** A PEM encoded X.509 certificate. */
    @Column(name = "certificate")
    private String certificate;


    @Column(name = "custom_data")
    private CustomData customData;

}
