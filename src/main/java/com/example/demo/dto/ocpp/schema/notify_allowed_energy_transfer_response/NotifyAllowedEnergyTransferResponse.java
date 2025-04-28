package com.example.demo.dto.ocpp.schema.notify_allowed_energy_transfer_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class NotifyAllowedEnergyTransferResponse {


    @JsonProperty("status")
    private NotifyAllowedEnergyTransferStatusEnum status;


    @JsonProperty("statusInfo")
    private StatusInfo statusInfo;


    @JsonProperty("customData")
    private CustomData customData;

}
