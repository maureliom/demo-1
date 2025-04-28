package com.example.demo.model.ocpp.schema.clear_charging_profile_request;

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
@Table(name = "clear_charging_profile_request")
public class ClearChargingProfileRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    /** The Id of the charging profile to clear. */
    @Column(name = "charging_profile_id")
    private Integer chargingProfileId;


    @Column(name = "charging_profile_criteria")
    private ClearChargingProfile chargingProfileCriteria;


    @Column(name = "custom_data")
    private CustomData customData;

}
