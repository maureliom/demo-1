package com.example.demo.dto.ocpp.schema.notify_evcharging_schedule_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class LimitAtSoC {


    @Min(0)
    @Max(100)
    /** The SoC value beyond which the charging rate limit should be applied. */
    @JsonProperty("soc")
    private Integer soc;

    @Min(0.0)
    @Max(100.0)

    /** Charging rate limit beyond the SoC value. The unit is defined by _chargingSchedule.chargingRateUnit_. */
    @JsonProperty("limit")
    private Double limit;


    @JsonProperty("customData")
    private CustomData customData;

}
