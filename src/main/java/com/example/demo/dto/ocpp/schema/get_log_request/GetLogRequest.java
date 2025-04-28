package com.example.demo.dto.ocpp.schema.get_log_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetLogRequest {


    @JsonProperty("log")
    private LogParameters log;


    @JsonProperty("logType")
    private LogEnum logType;


    /** The Id of this request */
    @JsonProperty("requestId")
    private Integer requestId;


    @Min(0)
    /** This specifies how many times the Charging Station must retry to upload the log before giving up. If this field is not present, it is left to Charging Station to decide how many times it wants to retry. If the value is 0, it means: no retries. */
    @JsonProperty("retries")
    private Integer retries;

    @Min(0.0)

    /** The interval in seconds after which a retry may be attempted. If this field is not present, it is left to Charging Station to decide how long to wait between attempts. */
    @JsonProperty("retryInterval")
    private Integer retryInterval;


    @JsonProperty("customData")
    private CustomData customData;

}
