package com.example.demo.dto.ocpp.schema.set_network_profile_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class VPN {


    @Size(max = 2000)
    /** VPN Server Address */
    @JsonProperty("server")
    private String server;


    @Size(max = 50)
    /** VPN User */
    @JsonProperty("user")
    private String user;


    @Size(max = 50)
    /** VPN group. */
    @JsonProperty("group")
    private String group;


    @Size(max = 64)
    /** *(2.1)* VPN Password. */
    @JsonProperty("password")
    private String password;


    @Size(max = 255)
    /** VPN shared secret. */
    @JsonProperty("key")
    private String key;


    @JsonProperty("type")
    private VPNEnum type;


    @JsonProperty("customData")
    private CustomData customData;

}
