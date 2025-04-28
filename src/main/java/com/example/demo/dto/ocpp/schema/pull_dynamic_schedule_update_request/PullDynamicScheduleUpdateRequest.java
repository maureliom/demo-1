package com.example.demo.dto.ocpp.schema.pull_dynamic_schedule_update_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class PullDynamicScheduleUpdateRequest {


    /** Id of charging profile to update. */
    @JsonProperty("chargingProfileId")
    private Integer chargingProfileId;


    @JsonProperty("customData")
    private CustomData customData;

}
