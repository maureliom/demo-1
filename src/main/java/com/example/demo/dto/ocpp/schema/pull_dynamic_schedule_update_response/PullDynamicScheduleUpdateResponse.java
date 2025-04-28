package com.example.demo.dto.ocpp.schema.pull_dynamic_schedule_update_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class PullDynamicScheduleUpdateResponse {


    @JsonProperty("scheduleUpdate")
    private ChargingScheduleUpdate scheduleUpdate;


    @JsonProperty("status")
    private ChargingProfileStatusEnum status;


    @JsonProperty("statusInfo")
    private StatusInfo statusInfo;


    @JsonProperty("customData")
    private CustomData customData;

}
