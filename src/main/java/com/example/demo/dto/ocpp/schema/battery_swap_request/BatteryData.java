package com.example.demo.dto.ocpp.schema.battery_swap_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class BatteryData {


    @Min(0)
    /** Slot number where battery is inserted or removed. */
    @JsonProperty("evseId")
    private Integer evseId;

    @Min(0.0)

    @Size(max = 50)
    /** Serial number of battery. */
    @JsonProperty("serialNumber")
    private String serialNumber;


    @Min(0)
    @Max(100)
    /** State of charge */
    @JsonProperty("soC")
    private Double soC;

    @Min(0.0)
    @Max(100.0)

    @Min(0)
    @Max(100)
    /** State of health */
    @JsonProperty("soH")
    private Double soH;

    @Min(0.0)
    @Max(100.0)

    /** Production date of battery. */
    @JsonProperty("productionDate")
    private String productionDate;


    @Size(max = 500)
    /** Vendor-specific info from battery in undefined format. */
    @JsonProperty("vendorInfo")
    private String vendorInfo;


    @JsonProperty("customData")
    private CustomData customData;

}
