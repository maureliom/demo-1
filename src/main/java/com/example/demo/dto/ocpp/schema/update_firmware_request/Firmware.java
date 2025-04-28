package com.example.demo.dto.ocpp.schema.update_firmware_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class Firmware {


    @Size(max = 2000)
    /** URI defining the origin of the firmware. */
    @JsonProperty("location")
    private String location;


    /** Date and time at which the firmware shall be retrieved. */
    @JsonProperty("retrieveDateTime")
    private String retrieveDateTime;


    /** Date and time at which the firmware shall be installed. */
    @JsonProperty("installDateTime")
    private String installDateTime;


    @Size(max = 5500)
    /** Certificate with which the firmware was signed. PEM encoded X.509 certificate. */
    @JsonProperty("signingCertificate")
    private String signingCertificate;


    @Size(max = 800)
    /** Base64 encoded firmware signature. */
    @JsonProperty("signature")
    private String signature;


    @JsonProperty("customData")
    private CustomData customData;

}
