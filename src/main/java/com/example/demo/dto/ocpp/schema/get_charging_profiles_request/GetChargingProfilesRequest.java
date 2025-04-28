package com.example.demo.dto.ocpp.schema.get_charging_profiles_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetChargingProfilesRequest {


    /** Reference identification that is to be used by the Charging Station in the &lt;&lt;reportchargingprofilesrequest, ReportChargingProfilesRequest&gt;&gt; when provided. */
    @JsonProperty("requestId")
    private Integer requestId;


    @Min(0)
    /** For which EVSE installed charging profiles SHALL be reported. If 0, only charging profiles installed on the Charging Station itself (the grid connection) SHALL be reported. If omitted, all installed charging profiles SHALL be reported. + Reported charging profiles SHALL match the criteria in field _chargingProfile_. */
    @JsonProperty("evseId")
    private Integer evseId;

    @Min(0.0)

    @JsonProperty("chargingProfile")
    private ChargingProfileCriterion chargingProfile;


    @JsonProperty("customData")
    private CustomData customData;

}
