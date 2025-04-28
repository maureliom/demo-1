package com.example.demo.model.ocpp.schema.notify_charging_limit_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Column(name = "soc")
    private Integer soc;

    @Min(0.0)
    @Max(100.0)

    /** Charging rate limit beyond the SoC value. The unit is defined by _chargingSchedule.chargingRateUnit_. */
    @Column(name = "limit")
    private Double limit;


    @Column(name = "custom_data")
    private CustomData customData;

}
