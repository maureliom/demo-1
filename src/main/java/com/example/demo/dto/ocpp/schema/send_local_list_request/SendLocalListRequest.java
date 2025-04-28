package com.example.demo.dto.ocpp.schema.send_local_list_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class SendLocalListRequest {


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("localAuthorizationList")
    private List<AuthorizationData> localAuthorizationList;

    @JsonProperty("localAuthorizationList")
    private List<AuthorizationData> localAuthorizationList = new ArrayList<>();


    /** In case of a full update this is the version number of the full list. In case of a differential update it is the version number of the list after the update has been applied. */
    @JsonProperty("versionNumber")
    private Integer versionNumber;


    @JsonProperty("updateType")
    private UpdateEnum updateType;


    @JsonProperty("customData")
    private CustomData customData;

}
