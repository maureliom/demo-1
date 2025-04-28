package com.example.demo.model.ocpp.schema.get_charging_profiles_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ChargingProfileCriterion {


    @Column(name = "charging_profile_purpose")
    private ChargingProfilePurposeEnum chargingProfilePurpose;


    @Min(0)
    /** Value determining level in hierarchy stack of profiles. Higher values have precedence over lower values. Lowest level is 0. */
    @Column(name = "stack_level")
    private Integer stackLevel;

    @Min(0.0)

    @ElementCollection
    @Size(min = 1)
    /** List of all the chargingProfileIds requested. Any ChargingProfile that matches one of these profiles will be reported. If omitted, the Charging Station SHALL not filter on chargingProfileId. This field SHALL NOT contain more ids than set in &lt;&lt;configkey-charging-profile-entries,ChargingProfileEntries.maxLimit&gt;&gt; */
    @Column(name = "charging_profile_id")
    private List<Integer> chargingProfileId;

    @ElementCollection
    private List<Integer> chargingProfileId = new ArrayList<>();


    @ElementCollection
    @Size(min = 1)
    @Size(max = 4)
    /** For which charging limit sources, charging profiles SHALL be reported. If omitted, the Charging Station SHALL not filter on chargingLimitSource. Values defined in Appendix as ChargingLimitSourceEnumStringType. */
    @Column(name = "charging_limit_source")
    private List<String> chargingLimitSource;

    @ElementCollection
    private List<String> chargingLimitSource = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
