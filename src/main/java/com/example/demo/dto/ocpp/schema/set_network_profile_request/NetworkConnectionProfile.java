package com.example.demo.dto.ocpp.schema.set_network_profile_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class NetworkConnectionProfile {


    @JsonProperty("apn")
    private APN apn;


    @JsonProperty("ocppVersion")
    private OCPPVersionEnum ocppVersion;


    @JsonProperty("ocppInterface")
    private OCPPInterfaceEnum ocppInterface;


    @JsonProperty("ocppTransport")
    private OCPPTransportEnum ocppTransport;


    /** Duration in seconds before a message send by the Charging Station via this network connection times-out. The best setting depends on the underlying network and response times of the CSMS. If you are looking for a some guideline: use 30 seconds as a starting point. */
    @JsonProperty("messageTimeout")
    private Integer messageTimeout;


    @Size(max = 2000)
    /** URL of the CSMS(s) that this Charging Station communicates with, without the Charging Station identity part. + The SecurityCtrlr.Identity field is appended to _ocppCsmsUrl_ to provide the full websocket URL. */
    @JsonProperty("ocppCsmsUrl")
    private String ocppCsmsUrl;


    @Min(0)
    /** This field specifies the security profile used when connecting to the CSMS with this NetworkConnectionProfile. */
    @JsonProperty("securityProfile")
    private Integer securityProfile;

    @Min(0.0)

    @Size(max = 48)
    /** *(2.1)* Charging Station identity to be used as the basic authentication username. */
    @JsonProperty("identity")
    private String identity;


    @Size(max = 64)
    /** *(2.1)* BasicAuthPassword to use for security profile 1 or 2. */
    @JsonProperty("basicAuthPassword")
    private String basicAuthPassword;


    @JsonProperty("vpn")
    private VPN vpn;


    @JsonProperty("customData")
    private CustomData customData;

}
