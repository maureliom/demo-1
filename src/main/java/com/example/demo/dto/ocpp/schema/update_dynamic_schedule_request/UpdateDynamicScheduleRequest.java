package com.example.demo.dto.ocpp.schema.update_dynamic_schedule_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class UpdateDynamicScheduleRequest {


    /** Id of charging profile to update. */
    @JsonProperty("chargingProfileId")
    private Integer chargingProfileId;


    @JsonProperty("scheduleUpdate")
    private ChargingScheduleUpdate scheduleUpdate;


    @JsonProperty("customData")
    private CustomData customData;

}
