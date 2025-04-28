package com.example.demo.dto.ocpp.schema.get_log_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetLogResponse {


    @JsonProperty("status")
    private LogStatusEnum status;


    @JsonProperty("statusInfo")
    private StatusInfo statusInfo;


    @Size(max = 255)
    /** This contains the name of the log file that will be uploaded. This field is not present when no logging information is available. */
    @JsonProperty("filename")
    private String filename;


    @JsonProperty("customData")
    private CustomData customData;

}
