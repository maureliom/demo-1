package com.example.demo.dto.ocpp.schema.notify_allowed_energy_transfer_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class NotifyAllowedEnergyTransferRequest {


    @Size(max = 36)
    /** The transaction for which the allowed energy transfer is allowed. */
    @JsonProperty("transactionId")
    private String transactionId;


    @ElementCollection
    @Size(min = 1)
    /** Modes of energy transfer that are accepted by CSMS. */
    @JsonProperty("allowedEnergyTransfer")
    private List<EnergyTransferModeEnum> allowedEnergyTransfer;

    @JsonProperty("allowedEnergyTransfer")
    private List<EnergyTransferModeEnum> allowedEnergyTransfer = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
