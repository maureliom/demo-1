package com.example.demo.dto.ocpp.schema.authorize_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class AuthorizeResponse {


    @JsonProperty("idTokenInfo")
    private IdTokenInfo idTokenInfo;


    @JsonProperty("certificateStatus")
    private AuthorizeCertificateStatusEnum certificateStatus;


    @ElementCollection
    @Size(min = 1)
    /** *(2.1)* List of allowed energy transfer modes the EV can choose from. If omitted this defaults to charging only. */
    @JsonProperty("allowedEnergyTransfer")
    private List<EnergyTransferModeEnum> allowedEnergyTransfer;

    @JsonProperty("allowedEnergyTransfer")
    private List<EnergyTransferModeEnum> allowedEnergyTransfer = new ArrayList<>();


    @JsonProperty("tariff")
    private Tariff tariff;


    @JsonProperty("customData")
    private CustomData customData;

}
