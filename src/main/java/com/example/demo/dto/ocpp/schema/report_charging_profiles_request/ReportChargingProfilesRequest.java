package com.example.demo.dto.ocpp.schema.report_charging_profiles_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ReportChargingProfilesRequest {


    /** Id used to match the &lt;&lt;getchargingprofilesrequest, GetChargingProfilesRequest&gt;&gt; message with the resulting ReportChargingProfilesRequest messages. When the CSMS provided a requestId in the &lt;&lt;getchargingprofilesrequest, GetChargingProfilesRequest&gt;&gt;, this field SHALL contain the same value. */
    @JsonProperty("requestId")
    private Integer requestId;


    @Size(max = 20)
    /** Source that has installed this charging profile. Values defined in Appendix as ChargingLimitSourceEnumStringType. */
    @JsonProperty("chargingLimitSource")
    private String chargingLimitSource;


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("chargingProfile")
    private List<ChargingProfile> chargingProfile;

    @JsonProperty("chargingProfile")
    private List<ChargingProfile> chargingProfile = new ArrayList<>();


    /** To Be Continued. Default value when omitted: false. false indicates that there are no further messages as part of this report. */
    @JsonProperty("tbc")
    private Boolean tbc;


    @Min(0)
    /** The evse to which the charging profile applies. If evseId = 0, the message contains an overall limit for the Charging Station. */
    @JsonProperty("evseId")
    private Integer evseId;

    @Min(0.0)

    @JsonProperty("customData")
    private CustomData customData;

}
