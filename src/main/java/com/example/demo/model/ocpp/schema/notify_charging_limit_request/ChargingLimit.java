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
public class ChargingLimit {


    @Size(max = 20)
    /** Represents the source of the charging limit. Values defined in appendix as ChargingLimitSourceEnumStringType. */
    @Column(name = "charging_limit_source")
    private String chargingLimitSource;


    /** *(2.1)* True when the reported limit concerns local generation that is providing extra capacity, instead of a limitation. */
    @Column(name = "is_local_generation")
    private Boolean isLocalGeneration;


    /** Indicates whether the charging limit is critical for the grid. */
    @Column(name = "is_grid_critical")
    private Boolean isGridCritical;


    @Column(name = "custom_data")
    private CustomData customData;

}
