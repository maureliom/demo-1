package com.example.demo.dto.ocpp.schema.get_local_list_version_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetLocalListVersionResponse {


    /** This contains the current version number of the local authorization list in the Charging Station. */
    @JsonProperty("versionNumber")
    private Integer versionNumber;


    @JsonProperty("customData")
    private CustomData customData;

}
