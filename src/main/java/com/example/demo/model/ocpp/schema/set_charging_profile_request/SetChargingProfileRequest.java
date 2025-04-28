package com.example.demo.model.ocpp.schema.set_charging_profile_request;

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
@Table(name = "set_charging_profile_request")
public class SetChargingProfileRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Min(0)
    /** For TxDefaultProfile an evseId=0 applies the profile to each individual evse. For ChargingStationMaxProfile and ChargingStationExternalConstraints an evseId=0 contains an overal limit for the whole Charging Station. */
    @Column(name = "evse_id")
    private Integer evseId;

    @Min(0.0)

    @Column(name = "charging_profile")
    private ChargingProfile chargingProfile;


    @Column(name = "custom_data")
    private CustomData customData;

}
