package com.example.demo.dto.ocpp.schema.get_installed_certificate_ids_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class CertificateHashDataChain {


    @JsonProperty("certificateHashData")
    private CertificateHashData certificateHashData;


    @JsonProperty("certificateType")
    private GetCertificateIdUseEnum certificateType;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 4)
    @JsonProperty("childCertificateHashData")
    private List<CertificateHashData> childCertificateHashData;

    @JsonProperty("childCertificateHashData")
    private List<CertificateHashData> childCertificateHashData = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
