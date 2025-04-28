package com.example.demo.model.ocpp.schema.get15118evcertificate_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "get15118evcertificate_request")
public class Get15118EVCertificateRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Size(max = 50)
    /** Schema version currently used for the 15118 session between EV and Charging Station. Needed for parsing of the EXI stream by the CSMS. */
    @Column(name = "iso15118schema_version")
    private String iso15118SchemaVersion;


    @Column(name = "action")
    private CertificateActionEnum action;


    @Size(max = 11000)
    /** *(2.1)* Raw CertificateInstallationReq request from EV, Base64 encoded. + Extended to support ISO 15118-20 certificates. The minimum supported length is 11000. If a longer _exiRequest_ is supported, then the supported length must be communicated in variable OCPPCommCtrlr.FieldLength[ \"Get15118EVCertificateRequest.exiRequest\" ]. */
    @Column(name = "exi_request")
    private String exiRequest;


    @Min(0)
    /** *(2.1)* Absent during ISO 15118-2 session. Required during ISO 15118-20 session. + Maximum number of contracts that EV wants to install. */
    @Column(name = "maximum_contract_certificate_chains")
    private Integer maximumContractCertificateChains;

    @Min(0.0)

    @ElementCollection
    @Size(min = 1)
    @Size(max = 8)
    /** *(2.1)* Absent during ISO 15118-2 session. Optional during ISO 15118-20 session. List of EMAIDs for which contract certificates must be requested first, in case there are more certificates than allowed by _maximumContractCertificateChains_. */
    @Column(name = "prioritized_emaids")
    private List<String> prioritizedEMAIDs;

    @ElementCollection
    private List<String> prioritizedEMAIDs = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
