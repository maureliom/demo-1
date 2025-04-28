package com.example.demo.dto.ocpp.schema.authorize_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class AuthorizeRequest {


    @JsonProperty("idToken")
    private IdToken idToken;


    @Size(max = 10000)
    /** *(2.1)* The X.509 certificate chain presented by EV and encoded in PEM format. Order of certificates in chain is from leaf up to (but excluding) root certificate. + Only needed in case of central contract validation when Charging Station cannot validate the contract certificate. */
    @JsonProperty("certificate")
    private String certificate;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 4)
    @JsonProperty("iso15118CertificateHashData")
    private List<OCSPRequestData> iso15118CertificateHashData;

    @JsonProperty("iso15118CertificateHashData")
    private List<OCSPRequestData> iso15118CertificateHashData = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
