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
public class APN {


    @Size(max = 2000)
    /** The Access Point Name as an URL. */
    @Column(name = "apn")
    private String apn;


    @Size(max = 50)
    /** APN username. */
    @Column(name = "apn_user_name")
    private String apnUserName;


    @Size(max = 64)
    /** *(2.1)* APN Password. */
    @Column(name = "apn_password")
    private String apnPassword;


    /** SIM card pin code. */
    @Column(name = "sim_pin")
    private Integer simPin;


    @Size(max = 6)
    /** Preferred network, written as MCC and MNC concatenated. See note. */
    @Column(name = "preferred_network")
    private String preferredNetwork;


    /** Default: false. Use only the preferred Network, do not dial in when not available. See Note. */
    @Column(name = "use_only_preferred_network")
    private Boolean useOnlyPreferredNetwork;


    @Column(name = "apn_authentication")
    private APNAuthenticationEnum apnAuthentication;


    @Column(name = "custom_data")
    private CustomData customData;

}
