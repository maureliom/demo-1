package com.example.demo.dto.ocpp.schema.set_variables_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class SetVariableResult {


    @JsonProperty("attributeType")
    private AttributeEnum attributeType;


    @JsonProperty("attributeStatus")
    private SetVariableStatusEnum attributeStatus;


    @JsonProperty("attributeStatusInfo")
    private StatusInfo attributeStatusInfo;


    @JsonProperty("component")
    private Component component;


    @JsonProperty("variable")
    private Variable variable;


    @JsonProperty("customData")
    private CustomData customData;

}
