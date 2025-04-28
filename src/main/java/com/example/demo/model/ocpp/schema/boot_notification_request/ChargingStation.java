package com.example.demo.model.ocpp.schema.boot_notification_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ChargingStation {


    @Size(max = 25)
    /** Vendor-specific device identifier. */
    @Column(name = "serial_number")
    private String serialNumber;


    @Size(max = 20)
    /** Defines the model of the device. */
    @Column(name = "model")
    private String model;


    @Column(name = "modem")
    private Modem modem;


    @Size(max = 50)
    /** Identifies the vendor (not necessarily in a unique manner). */
    @Column(name = "vendor_name")
    private String vendorName;


    @Size(max = 50)
    /** This contains the firmware version of the Charging Station. */
    @Column(name = "firmware_version")
    private String firmwareVersion;


    @Column(name = "custom_data")
    private CustomData customData;

}
