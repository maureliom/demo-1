package com.example.demo.dto.ocpp.schema.clear_charging_profile_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ClearChargingProfile {


    @Min(0)
    /** Specifies the id of the EVSE for which to clear charging profiles. An evseId of zero (0) specifies the charging profile for the overall Charging Station. Absence of this parameter means the clearing applies to all charging profiles that match the other criteria in the request. */
    @JsonProperty("evseId")
    private Integer evseId;

    @Min(0.0)

    @JsonProperty("chargingProfilePurpose")
    private ChargingProfilePurposeEnum chargingProfilePurpose;


    @Min(0)
    /** Specifies the stackLevel for which charging profiles will be cleared, if they meet the other criteria in the request. */
    @JsonProperty("stackLevel")
    private Integer stackLevel;

    @Min(0.0)

    @JsonProperty("customData")
    private CustomData customData;

}
