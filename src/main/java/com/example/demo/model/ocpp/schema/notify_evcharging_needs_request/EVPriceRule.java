package com.example.demo.model.ocpp.schema.notify_evcharging_needs_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class EVPriceRule {


    /** Cost per kWh. */
    @Column(name = "energy_fee")
    private Double energyFee;


    /** The EnergyFee applies between this value and the value of the PowerRangeStart of the subsequent EVPriceRule. If the power is below this value, the EnergyFee of the previous EVPriceRule applies. Negative values are used for discharging. */
    @Column(name = "power_range_start")
    private Double powerRangeStart;


    @Column(name = "custom_data")
    private CustomData customData;

}
