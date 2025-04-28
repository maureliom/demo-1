package com.example.demo.model.ocpp.schema.battery_swap_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class BatteryData {


    @Min(0)
    /** Slot number where battery is inserted or removed. */
    @Column(name = "evse_id")
    private Integer evseId;

    @Min(0.0)

    @Size(max = 50)
    /** Serial number of battery. */
    @Column(name = "serial_number")
    private String serialNumber;


    @Min(0)
    @Max(100)
    /** State of charge */
    @Column(name = "so_c")
    private Double soC;

    @Min(0.0)
    @Max(100.0)

    @Min(0)
    @Max(100)
    /** State of health */
    @Column(name = "so_h")
    private Double soH;

    @Min(0.0)
    @Max(100.0)

    /** Production date of battery. */
    @Column(name = "production_date")
    private String productionDate;


    @Size(max = 500)
    /** Vendor-specific info from battery in undefined format. */
    @Column(name = "vendor_info")
    private String vendorInfo;


    @Column(name = "custom_data")
    private CustomData customData;

}
