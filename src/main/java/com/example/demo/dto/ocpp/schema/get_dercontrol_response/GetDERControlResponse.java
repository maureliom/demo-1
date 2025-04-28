package com.example.demo.dto.ocpp.schema.get_dercontrol_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetDERControlResponse {


    @JsonProperty("status")
    private DERControlStatusEnum status;


    @JsonProperty("statusInfo")
    private StatusInfo statusInfo;


    @JsonProperty("customData")
    private CustomData customData;

}
