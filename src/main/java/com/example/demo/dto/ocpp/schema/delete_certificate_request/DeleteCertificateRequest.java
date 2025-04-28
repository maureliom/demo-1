package com.example.demo.dto.ocpp.schema.delete_certificate_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class DeleteCertificateRequest {


    @JsonProperty("certificateHashData")
    private CertificateHashData certificateHashData;


    @JsonProperty("customData")
    private CustomData customData;

}
