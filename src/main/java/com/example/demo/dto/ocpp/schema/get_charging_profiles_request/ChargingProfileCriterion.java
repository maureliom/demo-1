package com.example.demo.dto.ocpp.schema.get_charging_profiles_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ChargingProfileCriterion {


    @JsonProperty("chargingProfilePurpose")
    private ChargingProfilePurposeEnum chargingProfilePurpose;


    @Min(0)
    /** Value determining level in hierarchy stack of profiles. Higher values have precedence over lower values. Lowest level is 0. */
    @JsonProperty("stackLevel")
    private Integer stackLevel;

    @Min(0.0)

    @ElementCollection
    @Size(min = 1)
    /** List of all the chargingProfileIds requested. Any ChargingProfile that matches one of these profiles will be reported. If omitted, the Charging Station SHALL not filter on chargingProfileId. This field SHALL NOT contain more ids than set in &lt;&lt;configkey-charging-profile-entries,ChargingProfileEntries.maxLimit&gt;&gt; */
    @JsonProperty("chargingProfileId")
    private List<Integer> chargingProfileId;

    @JsonProperty("chargingProfileId")
    private List<Integer> chargingProfileId = new ArrayList<>();


    @ElementCollection
    @Size(min = 1)
    @Size(max = 4)
    /** For which charging limit sources, charging profiles SHALL be reported. If omitted, the Charging Station SHALL not filter on chargingLimitSource. Values defined in Appendix as ChargingLimitSourceEnumStringType. */
    @JsonProperty("chargingLimitSource")
    private List<String> chargingLimitSource;

    @JsonProperty("chargingLimitSource")
    private List<String> chargingLimitSource = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
