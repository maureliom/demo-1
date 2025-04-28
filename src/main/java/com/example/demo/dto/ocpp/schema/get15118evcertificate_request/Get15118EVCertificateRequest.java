package com.example.demo.dto.ocpp.schema.get15118evcertificate_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class Get15118EVCertificateRequest {


    @Size(max = 50)
    /** Schema version currently used for the 15118 session between EV and Charging Station. Needed for parsing of the EXI stream by the CSMS. */
    @JsonProperty("iso15118SchemaVersion")
    private String iso15118SchemaVersion;


    @JsonProperty("action")
    private CertificateActionEnum action;


    @Size(max = 11000)
    /** *(2.1)* Raw CertificateInstallationReq request from EV, Base64 encoded. + Extended to support ISO 15118-20 certificates. The minimum supported length is 11000. If a longer _exiRequest_ is supported, then the supported length must be communicated in variable OCPPCommCtrlr.FieldLength[ \"Get15118EVCertificateRequest.exiRequest\" ]. */
    @JsonProperty("exiRequest")
    private String exiRequest;


    @Min(0)
    /** *(2.1)* Absent during ISO 15118-2 session. Required during ISO 15118-20 session. + Maximum number of contracts that EV wants to install. */
    @JsonProperty("maximumContractCertificateChains")
    private Integer maximumContractCertificateChains;

    @Min(0.0)

    @ElementCollection
    @Size(min = 1)
    @Size(max = 8)
    /** *(2.1)* Absent during ISO 15118-2 session. Optional during ISO 15118-20 session. List of EMAIDs for which contract certificates must be requested first, in case there are more certificates than allowed by _maximumContractCertificateChains_. */
    @JsonProperty("prioritizedEMAIDs")
    private List<String> prioritizedEMAIDs;

    @JsonProperty("prioritizedEMAIDs")
    private List<String> prioritizedEMAIDs = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
