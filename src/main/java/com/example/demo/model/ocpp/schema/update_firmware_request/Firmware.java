package com.example.demo.model.ocpp.schema.update_firmware_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class Firmware {


    @Size(max = 2000)
    /** URI defining the origin of the firmware. */
    @Column(name = "location")
    private String location;


    /** Date and time at which the firmware shall be retrieved. */
    @Column(name = "retrieve_date_time")
    private String retrieveDateTime;


    /** Date and time at which the firmware shall be installed. */
    @Column(name = "install_date_time")
    private String installDateTime;


    @Size(max = 5500)
    /** Certificate with which the firmware was signed. PEM encoded X.509 certificate. */
    @Column(name = "signing_certificate")
    private String signingCertificate;


    @Size(max = 800)
    /** Base64 encoded firmware signature. */
    @Column(name = "signature")
    private String signature;


    @Column(name = "custom_data")
    private CustomData customData;

}
