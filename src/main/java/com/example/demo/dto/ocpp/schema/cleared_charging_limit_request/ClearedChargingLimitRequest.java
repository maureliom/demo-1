package com.example.demo.dto.ocpp.schema.cleared_charging_limit_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ClearedChargingLimitRequest {


    @Size(max = 20)
    /** Source of the charging limit. Allowed values defined in Appendix as ChargingLimitSourceEnumStringType. */
    @JsonProperty("chargingLimitSource")
    private String chargingLimitSource;


    @Min(0)
    /** EVSE Identifier. */
    @JsonProperty("evseId")
    private Integer evseId;

    @Min(0.0)

    @JsonProperty("customData")
    private CustomData customData;

}
