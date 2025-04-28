package com.example.demo.dto.ocpp.schema.get15118evcertificate_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class Get15118EVCertificateResponse {


    @JsonProperty("status")
    private Iso15118EVCertificateStatusEnum status;


    @JsonProperty("statusInfo")
    private StatusInfo statusInfo;


    @Size(max = 17000)
    /** *(2/1)* Raw CertificateInstallationRes response for the EV, Base64 encoded. + Extended to support ISO 15118-20 certificates. The minimum supported length is 17000. If a longer _exiResponse_ is supported, then the supported length must be communicated in variable OCPPCommCtrlr.FieldLength[ \"Get15118EVCertificateResponse.exiResponse\" ]. */
    @JsonProperty("exiResponse")
    private String exiResponse;


    @Min(0)
    /** *(2.1)* Number of contracts that can be retrieved with additional requests. */
    @JsonProperty("remainingContracts")
    private Integer remainingContracts;

    @Min(0.0)

    @JsonProperty("customData")
    private CustomData customData;

}
