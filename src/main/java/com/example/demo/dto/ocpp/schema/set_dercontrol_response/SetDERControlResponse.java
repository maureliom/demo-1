package com.example.demo.dto.ocpp.schema.set_dercontrol_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class SetDERControlResponse {


    @JsonProperty("status")
    private DERControlStatusEnum status;


    @JsonProperty("statusInfo")
    private StatusInfo statusInfo;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 24)
    /** List of controlIds that are superseded as a result of setting this control. */
    @JsonProperty("supersededIds")
    private List<String> supersededIds;

    @JsonProperty("supersededIds")
    private List<String> supersededIds = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
