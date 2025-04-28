package com.example.demo.dto.ocpp.schema.transaction_event_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class TotalUsage {


    @JsonProperty("energy")
    private Double energy;


    /** Total duration of the charging session (including the duration of charging and not charging), in seconds. */
    @JsonProperty("chargingTime")
    private Integer chargingTime;


    /** Total duration of the charging session where the EV was not charging (no energy was transferred between EVSE and EV), in seconds. */
    @JsonProperty("idleTime")
    private Integer idleTime;


    /** Total time of reservation in seconds. */
    @JsonProperty("reservationTime")
    private Integer reservationTime;


    @JsonProperty("customData")
    private CustomData customData;

}
