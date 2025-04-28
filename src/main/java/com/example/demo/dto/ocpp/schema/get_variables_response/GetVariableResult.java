package com.example.demo.dto.ocpp.schema.get_variables_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetVariableResult {


    @JsonProperty("attributeStatus")
    private GetVariableStatusEnum attributeStatus;


    @JsonProperty("attributeStatusInfo")
    private StatusInfo attributeStatusInfo;


    @JsonProperty("attributeType")
    private AttributeEnum attributeType;


    @Size(max = 2500)
    /** Value of requested attribute type of component-variable. This field can only be empty when the given status is NOT accepted. The Configuration Variable &lt;&lt;configkey-reporting-value-size,ReportingValueSize&gt;&gt; can be used to limit GetVariableResult.attributeValue, VariableAttribute.value and EventData.actualValue. The max size of these values will always remain equal. */
    @JsonProperty("attributeValue")
    private String attributeValue;


    @JsonProperty("component")
    private Component component;


    @JsonProperty("variable")
    private Variable variable;


    @JsonProperty("customData")
    private CustomData customData;

}
