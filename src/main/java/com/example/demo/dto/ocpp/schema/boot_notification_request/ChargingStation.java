package com.example.demo.dto.ocpp.schema.boot_notification_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ChargingStation {


    @Size(max = 25)
    /** Vendor-specific device identifier. */
    @JsonProperty("serialNumber")
    private String serialNumber;


    @Size(max = 20)
    /** Defines the model of the device. */
    @JsonProperty("model")
    private String model;


    @JsonProperty("modem")
    private Modem modem;


    @Size(max = 50)
    /** Identifies the vendor (not necessarily in a unique manner). */
    @JsonProperty("vendorName")
    private String vendorName;


    @Size(max = 50)
    /** This contains the firmware version of the Charging Station. */
    @JsonProperty("firmwareVersion")
    private String firmwareVersion;


    @JsonProperty("customData")
    private CustomData customData;

}
