package com.example.demo.dto.ocpp.schema.get_certificate_status_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetCertificateStatusRequest {


    @JsonProperty("ocspRequestData")
    private OCSPRequestData ocspRequestData;


    @JsonProperty("customData")
    private CustomData customData;

}
