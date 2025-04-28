package com.example.demo.dto.ocpp.schema.get_variables_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetVariableData {


    @JsonProperty("attributeType")
    private AttributeEnum attributeType;


    @JsonProperty("component")
    private Component component;


    @JsonProperty("variable")
    private Variable variable;


    @JsonProperty("customData")
    private CustomData customData;

}
