package com.example.demo.dto.ocpp.schema.get_certificate_chain_status_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class CertificateStatus {


    @JsonProperty("certificateHashData")
    private CertificateHashData certificateHashData;


    @JsonProperty("source")
    private CertificateStatusSourceEnum source;


    @JsonProperty("status")
    private CertificateStatusEnum status;


    @JsonProperty("nextUpdate")
    private String nextUpdate;


    @JsonProperty("customData")
    private CustomData customData;

}
