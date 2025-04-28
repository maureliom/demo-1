package com.example.demo.dto.ocpp.schema.install_certificate_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class InstallCertificateRequest {


    @JsonProperty("certificateType")
    private InstallCertificateUseEnum certificateType;


    @Size(max = 10000)
    /** A PEM encoded X.509 certificate. */
    @JsonProperty("certificate")
    private String certificate;


    @JsonProperty("customData")
    private CustomData customData;

}
