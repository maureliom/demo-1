package com.example.demo.model.ocpp.schema.certificate_signed_request;

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
@Table(name = "certificate_signed_request")
public class CertificateSignedRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Size(max = 10000)
    /** The signed PEM encoded X.509 certificate. This SHALL also contain the necessary sub CA certificates, when applicable. The order of the bundle follows the certificate chain, starting from the leaf certificate. The Configuration Variable &lt;&lt;configkey-max-certificate-chain-size,MaxCertificateChainSize&gt;&gt; can be used to limit the maximum size of this field. */
    @Column(name = "certificate_chain")
    private String certificateChain;


    @Column(name = "certificate_type")
    private CertificateSigningUseEnum certificateType;


    /** *(2.1)* RequestId to correlate this message with the SignCertificateRequest. */
    @Column(name = "request_id")
    private Integer requestId;


    @Column(name = "custom_data")
    private CustomData customData;

}
