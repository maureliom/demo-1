package com.example.demo.dto.ocpp.schema.certificate_signed_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class CertificateSignedRequest {


    @Size(max = 10000)
    /** The signed PEM encoded X.509 certificate. This SHALL also contain the necessary sub CA certificates, when applicable. The order of the bundle follows the certificate chain, starting from the leaf certificate. The Configuration Variable &lt;&lt;configkey-max-certificate-chain-size,MaxCertificateChainSize&gt;&gt; can be used to limit the maximum size of this field. */
    @JsonProperty("certificateChain")
    private String certificateChain;


    @JsonProperty("certificateType")
    private CertificateSigningUseEnum certificateType;


    /** *(2.1)* RequestId to correlate this message with the SignCertificateRequest. */
    @JsonProperty("requestId")
    private Integer requestId;


    @JsonProperty("customData")
    private CustomData customData;

}
