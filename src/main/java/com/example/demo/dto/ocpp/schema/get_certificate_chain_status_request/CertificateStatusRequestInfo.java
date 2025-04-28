package com.example.demo.dto.ocpp.schema.get_certificate_chain_status_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class CertificateStatusRequestInfo {


    @JsonProperty("certificateHashData")
    private CertificateHashData certificateHashData;


    @JsonProperty("source")
    private CertificateStatusSourceEnum source;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 5)
    /** URL(s) of _source_. */
    @JsonProperty("urls")
    private List<String> urls;

    @JsonProperty("urls")
    private List<String> urls = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
