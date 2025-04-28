package com.example.demo.dto.ocpp.schema.get_installed_certificate_ids_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetInstalledCertificateIdsResponse {


    @JsonProperty("status")
    private GetInstalledCertificateStatusEnum status;


    @JsonProperty("statusInfo")
    private StatusInfo statusInfo;


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("certificateHashDataChain")
    private List<CertificateHashDataChain> certificateHashDataChain;

    @JsonProperty("certificateHashDataChain")
    private List<CertificateHashDataChain> certificateHashDataChain = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
