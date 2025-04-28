package com.example.demo.model.ocpp.schema.get15118evcertificate_response;

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
@Table(name = "get15118evcertificate_response")
public class Get15118EVCertificateResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "status")
    private Iso15118EVCertificateStatusEnum status;


    @Column(name = "status_info")
    private StatusInfo statusInfo;


    @Size(max = 17000)
    /** *(2/1)* Raw CertificateInstallationRes response for the EV, Base64 encoded. + Extended to support ISO 15118-20 certificates. The minimum supported length is 17000. If a longer _exiResponse_ is supported, then the supported length must be communicated in variable OCPPCommCtrlr.FieldLength[ \"Get15118EVCertificateResponse.exiResponse\" ]. */
    @Column(name = "exi_response")
    private String exiResponse;


    @Min(0)
    /** *(2.1)* Number of contracts that can be retrieved with additional requests. */
    @Column(name = "remaining_contracts")
    private Integer remainingContracts;

    @Min(0.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
