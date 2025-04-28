package com.example.demo.dto.ocpp.schema.report_dercontrol_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class EnterServiceGet {


    @JsonProperty("enterService")
    private EnterService enterService;


    @Size(max = 36)
    /** Id of setting */
    @JsonProperty("id")
    private String id;


    @JsonProperty("customData")
    private CustomData customData;

}
