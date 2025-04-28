package com.example.demo.dto.ocpp.schema.certificate_signed_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class CertificateSignedResponse {


    @JsonProperty("status")
    private CertificateSignedStatusEnum status;


    @JsonProperty("statusInfo")
    private StatusInfo statusInfo;


    @JsonProperty("customData")
    private CustomData customData;

}
