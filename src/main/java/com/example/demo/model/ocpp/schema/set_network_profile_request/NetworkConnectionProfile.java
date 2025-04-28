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
public class NetworkConnectionProfile {


    @Column(name = "apn")
    private APN apn;


    @Column(name = "ocpp_version")
    private OCPPVersionEnum ocppVersion;


    @Column(name = "ocpp_interface")
    private OCPPInterfaceEnum ocppInterface;


    @Column(name = "ocpp_transport")
    private OCPPTransportEnum ocppTransport;


    /** Duration in seconds before a message send by the Charging Station via this network connection times-out. The best setting depends on the underlying network and response times of the CSMS. If you are looking for a some guideline: use 30 seconds as a starting point. */
    @Column(name = "message_timeout")
    private Integer messageTimeout;


    @Size(max = 2000)
    /** URL of the CSMS(s) that this Charging Station communicates with, without the Charging Station identity part. + The SecurityCtrlr.Identity field is appended to _ocppCsmsUrl_ to provide the full websocket URL. */
    @Column(name = "ocpp_csms_url")
    private String ocppCsmsUrl;


    @Min(0)
    /** This field specifies the security profile used when connecting to the CSMS with this NetworkConnectionProfile. */
    @Column(name = "security_profile")
    private Integer securityProfile;

    @Min(0.0)

    @Size(max = 48)
    /** *(2.1)* Charging Station identity to be used as the basic authentication username. */
    @Column(name = "identity")
    private String identity;


    @Size(max = 64)
    /** *(2.1)* BasicAuthPassword to use for security profile 1 or 2. */
    @Column(name = "basic_auth_password")
    private String basicAuthPassword;


    @Column(name = "vpn")
    private VPN vpn;


    @Column(name = "custom_data")
    private CustomData customData;

}
