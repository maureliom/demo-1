package com.example.demo.dto.ocpp.schema.clear_charging_profile_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ClearChargingProfileRequest {


    /** The Id of the charging profile to clear. */
    @JsonProperty("chargingProfileId")
    private Integer chargingProfileId;


    @JsonProperty("chargingProfileCriteria")
    private ClearChargingProfile chargingProfileCriteria;


    @JsonProperty("customData")
    private CustomData customData;

}
