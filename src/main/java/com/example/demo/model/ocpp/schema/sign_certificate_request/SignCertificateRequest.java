package com.example.demo.model.ocpp.schema.sign_certificate_request;

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
@Table(name = "sign_certificate_request")
public class SignCertificateRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Size(max = 5500)
    /** The Charging Station SHALL send the public key in form of a Certificate Signing Request (CSR) as described in RFC 2986 [22] and then PEM encoded, using the &lt;&lt;signcertificaterequest,SignCertificateRequest&gt;&gt; message. */
    @Column(name = "csr")
    private String csr;


    @Column(name = "certificate_type")
    private CertificateSigningUseEnum certificateType;


    @Column(name = "hash_root_certificate")
    private CertificateHashData hashRootCertificate;


    /** *(2.1)* RequestId to match this message with the CertificateSignedRequest. */
    @Column(name = "request_id")
    private Integer requestId;


    @Column(name = "custom_data")
    private CustomData customData;

}
