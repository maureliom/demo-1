package com.example.demo.model.ocpp.schema.report_charging_profiles_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "report_charging_profiles_request")
public class ReportChargingProfilesRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    /** Id used to match the &lt;&lt;getchargingprofilesrequest, GetChargingProfilesRequest&gt;&gt; message with the resulting ReportChargingProfilesRequest messages. When the CSMS provided a requestId in the &lt;&lt;getchargingprofilesrequest, GetChargingProfilesRequest&gt;&gt;, this field SHALL contain the same value. */
    @Column(name = "request_id")
    private Integer requestId;


    @Size(max = 20)
    /** Source that has installed this charging profile. Values defined in Appendix as ChargingLimitSourceEnumStringType. */
    @Column(name = "charging_limit_source")
    private String chargingLimitSource;


    @ElementCollection
    @Size(min = 1)
    @Column(name = "charging_profile")
    private List<ChargingProfile> chargingProfile;

    @ElementCollection
    private List<ChargingProfile> chargingProfile = new ArrayList<>();


    /** To Be Continued. Default value when omitted: false. false indicates that there are no further messages as part of this report. */
    @Column(name = "tbc")
    private Boolean tbc;


    @Min(0)
    /** The evse to which the charging profile applies. If evseId = 0, the message contains an overall limit for the Charging Station. */
    @Column(name = "evse_id")
    private Integer evseId;

    @Min(0.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
