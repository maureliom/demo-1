package com.example.demo.model.ocpp.schema.report_charging_profiles_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class PriceRule {


    /** The duration of the parking fee period (in seconds). When the time enters into a ParkingFeePeriod, the ParkingFee will apply to the session. . */
    @Column(name = "parking_fee_period")
    private Integer parkingFeePeriod;


    @Min(0)
    /** Number of grams of CO2 per kWh. */
    @Column(name = "carbon_dioxide_emission")
    private Integer carbonDioxideEmission;

    @Min(0.0)

    @Min(0)
    @Max(100)
    /** Percentage of the power that is created by renewable resources. */
    @Column(name = "renewable_generation_percentage")
    private Integer renewableGenerationPercentage;

    @Min(0.0)
    @Max(100.0)

    @Column(name = "energy_fee")
    private RationalNumber energyFee;


    @Column(name = "parking_fee")
    private RationalNumber parkingFee;


    @Column(name = "power_range_start")
    private RationalNumber powerRangeStart;


    @Column(name = "custom_data")
    private CustomData customData;

}
