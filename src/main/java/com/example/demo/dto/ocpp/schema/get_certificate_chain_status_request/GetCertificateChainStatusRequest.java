package com.example.demo.dto.ocpp.schema.get_certificate_chain_status_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetCertificateChainStatusRequest {


    @ElementCollection
    @Size(min = 1)
    @Size(max = 4)
    @JsonProperty("certificateStatusRequests")
    private List<CertificateStatusRequestInfo> certificateStatusRequests;

    @JsonProperty("certificateStatusRequests")
    private List<CertificateStatusRequestInfo> certificateStatusRequests = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
