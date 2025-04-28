package com.example.demo.dto.ocpp.schema.set_variables_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class SetVariableData {


    @JsonProperty("attributeType")
    private AttributeEnum attributeType;


    @Size(max = 2500)
    /** Value to be assigned to attribute of variable. This value is allowed to be an empty string (\"\"). The Configuration Variable &lt;&lt;configkey-configuration-value-size,ConfigurationValueSize&gt;&gt; can be used to limit SetVariableData.attributeValue and VariableCharacteristics.valuesList. The max size of these values will always remain equal. */
    @JsonProperty("attributeValue")
    private String attributeValue;


    @JsonProperty("component")
    private Component component;


    @JsonProperty("variable")
    private Variable variable;


    @JsonProperty("customData")
    private CustomData customData;

}
