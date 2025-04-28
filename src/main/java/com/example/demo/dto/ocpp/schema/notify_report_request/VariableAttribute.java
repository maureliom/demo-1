package com.example.demo.dto.ocpp.schema.notify_report_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class VariableAttribute {


    @JsonProperty("type")
    private AttributeEnum type;


    @Size(max = 2500)
    /** Value of the attribute. May only be omitted when mutability is set to 'WriteOnly'. The Configuration Variable &lt;&lt;configkey-reporting-value-size,ReportingValueSize&gt;&gt; can be used to limit GetVariableResult.attributeValue, VariableAttribute.value and EventData.actualValue. The max size of these values will always remain equal. */
    @JsonProperty("value")
    private String value;


    @JsonProperty("mutability")
    private MutabilityEnum mutability;


    /** If true, value will be persistent across system reboots or power down. Default when omitted is false. */
    @JsonProperty("persistent")
    private Boolean persistent;


    /** If true, value that will never be changed by the Charging Station at runtime. Default when omitted is false. */
    @JsonProperty("constant")
    private Boolean constant;


    @JsonProperty("customData")
    private CustomData customData;

}
