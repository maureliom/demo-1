package com.example.demo.dto.ocpp.schema.get_installed_certificate_ids_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetInstalledCertificateIdsRequest {


    @ElementCollection
    @Size(min = 1)
    /** Indicates the type of certificates requested. When omitted, all certificate types are requested. */
    @JsonProperty("certificateType")
    private List<GetCertificateIdUseEnum> certificateType;

    @JsonProperty("certificateType")
    private List<GetCertificateIdUseEnum> certificateType = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
