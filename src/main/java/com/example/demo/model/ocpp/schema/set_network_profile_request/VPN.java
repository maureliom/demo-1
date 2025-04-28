package com.example.demo.model.ocpp.schema.set_network_profile_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class VPN {


    @Size(max = 2000)
    /** VPN Server Address */
    @Column(name = "server")
    private String server;


    @Size(max = 50)
    /** VPN User */
    @Column(name = "user")
    private String user;


    @Size(max = 50)
    /** VPN group. */
    @Column(name = "group")
    private String group;


    @Size(max = 64)
    /** *(2.1)* VPN Password. */
    @Column(name = "password")
    private String password;


    @Size(max = 255)
    /** VPN shared secret. */
    @Column(name = "key")
    private String key;


    @Column(name = "type")
    private VPNEnum type;


    @Column(name = "custom_data")
    private CustomData customData;

}
