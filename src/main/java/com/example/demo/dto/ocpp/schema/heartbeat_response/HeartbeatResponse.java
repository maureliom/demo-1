package com.example.demo.dto.ocpp.schema.heartbeat_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class HeartbeatResponse {


    /** Contains the current time of the CSMS. */
    @JsonProperty("currentTime")
    private String currentTime;


    @JsonProperty("customData")
    private CustomData customData;

}
