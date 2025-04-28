package com.example.demo.dto.ocpp.schema.notify_evcharging_needs_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class EVPriceRule {


    /** Cost per kWh. */
    @JsonProperty("energyFee")
    private Double energyFee;


    /** The EnergyFee applies between this value and the value of the PowerRangeStart of the subsequent EVPriceRule. If the power is below this value, the EnergyFee of the previous EVPriceRule applies. Negative values are used for discharging. */
    @JsonProperty("powerRangeStart")
    private Double powerRangeStart;


    @JsonProperty("customData")
    private CustomData customData;

}
