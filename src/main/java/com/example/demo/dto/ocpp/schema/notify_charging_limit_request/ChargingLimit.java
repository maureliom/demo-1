package com.example.demo.dto.ocpp.schema.notify_charging_limit_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ChargingLimit {


    @Size(max = 20)
    /** Represents the source of the charging limit. Values defined in appendix as ChargingLimitSourceEnumStringType. */
    @JsonProperty("chargingLimitSource")
    private String chargingLimitSource;


    /** *(2.1)* True when the reported limit concerns local generation that is providing extra capacity, instead of a limitation. */
    @JsonProperty("isLocalGeneration")
    private Boolean isLocalGeneration;


    /** Indicates whether the charging limit is critical for the grid. */
    @JsonProperty("isGridCritical")
    private Boolean isGridCritical;


    @JsonProperty("customData")
    private CustomData customData;

}
