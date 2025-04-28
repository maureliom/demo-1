package com.example.demo.dto.ocpp.schema.set_network_profile_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class StatusInfo {


    @Size(max = 20)
    /** A predefined code for the reason why the status is returned in this response. The string is case-insensitive. */
    @JsonProperty("reasonCode")
    private String reasonCode;


    @Size(max = 1024)
    /** Additional text to provide detailed information. */
    @JsonProperty("additionalInfo")
    private String additionalInfo;


    @JsonProperty("customData")
    private CustomData customData;

}
