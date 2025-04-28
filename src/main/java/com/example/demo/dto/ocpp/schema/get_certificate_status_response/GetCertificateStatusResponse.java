package com.example.demo.dto.ocpp.schema.get_certificate_status_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetCertificateStatusResponse {


    @JsonProperty("status")
    private GetCertificateStatusEnum status;


    @JsonProperty("statusInfo")
    private StatusInfo statusInfo;


    @Size(max = 18000)
    /** *(2.1)* OCSPResponse class as defined in &lt;&lt;ref-ocpp_security_24, IETF RFC 6960&gt;&gt;. DER encoded (as defined in &lt;&lt;ref-ocpp_security_24, IETF RFC 6960&gt;&gt;), and then base64 encoded. MAY only be omitted when status is not Accepted. + The minimum supported length is 18000. If a longer _ocspResult_ is supported, then the supported length must be communicated in variable OCPPCommCtrlr.FieldLength[ \"GetCertificateStatusResponse.ocspResult\" ]. */
    @JsonProperty("ocspResult")
    private String ocspResult;


    @JsonProperty("customData")
    private CustomData customData;

}
