package com.example.demo.dto.ocpp.schema.get_log_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class LogParameters {


    @Size(max = 2000)
    /** The URL of the location at the remote system where the log should be stored. */
    @JsonProperty("remoteLocation")
    private String remoteLocation;


    /** This contains the date and time of the oldest logging information to include in the diagnostics. */
    @JsonProperty("oldestTimestamp")
    private String oldestTimestamp;


    /** This contains the date and time of the latest logging information to include in the diagnostics. */
    @JsonProperty("latestTimestamp")
    private String latestTimestamp;


    @JsonProperty("customData")
    private CustomData customData;

}
