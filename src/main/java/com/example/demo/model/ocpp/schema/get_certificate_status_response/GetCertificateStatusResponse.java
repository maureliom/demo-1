package com.example.demo.model.ocpp.schema.get_certificate_status_response;

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
@Table(name = "get_certificate_status_response")
public class GetCertificateStatusResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "status")
    private GetCertificateStatusEnum status;


    @Column(name = "status_info")
    private StatusInfo statusInfo;


    @Size(max = 18000)
    /** *(2.1)* OCSPResponse class as defined in &lt;&lt;ref-ocpp_security_24, IETF RFC 6960&gt;&gt;. DER encoded (as defined in &lt;&lt;ref-ocpp_security_24, IETF RFC 6960&gt;&gt;), and then base64 encoded. MAY only be omitted when status is not Accepted. + The minimum supported length is 18000. If a longer _ocspResult_ is supported, then the supported length must be communicated in variable OCPPCommCtrlr.FieldLength[ \"GetCertificateStatusResponse.ocspResult\" ]. */
    @Column(name = "ocsp_result")
    private String ocspResult;


    @Column(name = "custom_data")
    private CustomData customData;

}
