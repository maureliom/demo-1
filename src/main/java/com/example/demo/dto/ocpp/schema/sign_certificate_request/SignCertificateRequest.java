package com.example.demo.dto.ocpp.schema.sign_certificate_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class SignCertificateRequest {


    @Size(max = 5500)
    /** The Charging Station SHALL send the public key in form of a Certificate Signing Request (CSR) as described in RFC 2986 [22] and then PEM encoded, using the &lt;&lt;signcertificaterequest,SignCertificateRequest&gt;&gt; message. */
    @JsonProperty("csr")
    private String csr;


    @JsonProperty("certificateType")
    private CertificateSigningUseEnum certificateType;


    @JsonProperty("hashRootCertificate")
    private CertificateHashData hashRootCertificate;


    /** *(2.1)* RequestId to match this message with the CertificateSignedRequest. */
    @JsonProperty("requestId")
    private Integer requestId;


    @JsonProperty("customData")
    private CustomData customData;

}
