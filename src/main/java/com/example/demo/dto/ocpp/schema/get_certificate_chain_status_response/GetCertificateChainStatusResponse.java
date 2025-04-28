package com.example.demo.dto.ocpp.schema.get_certificate_chain_status_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetCertificateChainStatusResponse {


    @ElementCollection
    @Size(min = 1)
    @Size(max = 4)
    @JsonProperty("certificateStatus")
    private List<CertificateStatus> certificateStatus;

    @JsonProperty("certificateStatus")
    private List<CertificateStatus> certificateStatus = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
