package com.example.demo.dto.ocpp.schema.set_network_profile_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class SetNetworkProfileRequest {


    /** Slot in which the configuration should be stored. */
    @JsonProperty("configurationSlot")
    private Integer configurationSlot;


    @JsonProperty("connectionData")
    private NetworkConnectionProfile connectionData;


    @JsonProperty("customData")
    private CustomData customData;

}
