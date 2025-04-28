package com.example.demo.dto.ocpp.schema.set_network_profile_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class APN {


    @Size(max = 2000)
    /** The Access Point Name as an URL. */
    @JsonProperty("apn")
    private String apn;


    @Size(max = 50)
    /** APN username. */
    @JsonProperty("apnUserName")
    private String apnUserName;


    @Size(max = 64)
    /** *(2.1)* APN Password. */
    @JsonProperty("apnPassword")
    private String apnPassword;


    /** SIM card pin code. */
    @JsonProperty("simPin")
    private Integer simPin;


    @Size(max = 6)
    /** Preferred network, written as MCC and MNC concatenated. See note. */
    @JsonProperty("preferredNetwork")
    private String preferredNetwork;


    /** Default: false. Use only the preferred Network, do not dial in when not available. See Note. */
    @JsonProperty("useOnlyPreferredNetwork")
    private Boolean useOnlyPreferredNetwork;


    @JsonProperty("apnAuthentication")
    private APNAuthenticationEnum apnAuthentication;


    @JsonProperty("customData")
    private CustomData customData;

}
