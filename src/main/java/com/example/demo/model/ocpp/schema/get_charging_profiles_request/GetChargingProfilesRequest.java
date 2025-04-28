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
@Entity
@Table(name = "get_charging_profiles_request")
public class GetChargingProfilesRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    /** Reference identification that is to be used by the Charging Station in the &lt;&lt;reportchargingprofilesrequest, ReportChargingProfilesRequest&gt;&gt; when provided. */
    @Column(name = "request_id")
    private Integer requestId;


    @Min(0)
    /** For which EVSE installed charging profiles SHALL be reported. If 0, only charging profiles installed on the Charging Station itself (the grid connection) SHALL be reported. If omitted, all installed charging profiles SHALL be reported. + Reported charging profiles SHALL match the criteria in field _chargingProfile_. */
    @Column(name = "evse_id")
    private Integer evseId;

    @Min(0.0)

    @Column(name = "charging_profile")
    private ChargingProfileCriterion chargingProfile;


    @Column(name = "custom_data")
    private CustomData customData;

}
