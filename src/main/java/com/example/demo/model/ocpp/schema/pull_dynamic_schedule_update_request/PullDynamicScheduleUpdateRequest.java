package com.example.demo.model.ocpp.schema.pull_dynamic_schedule_update_request;

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
@Table(name = "pull_dynamic_schedule_update_request")
public class PullDynamicScheduleUpdateRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    /** Id of charging profile to update. */
    @Column(name = "charging_profile_id")
    private Integer chargingProfileId;


    @Column(name = "custom_data")
    private CustomData customData;

}
