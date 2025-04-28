package com.example.demo.model.ocpp.schema.notify_report_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class VariableAttribute {


    @Column(name = "type")
    private AttributeEnum type;


    @Size(max = 2500)
    /** Value of the attribute. May only be omitted when mutability is set to 'WriteOnly'. The Configuration Variable &lt;&lt;configkey-reporting-value-size,ReportingValueSize&gt;&gt; can be used to limit GetVariableResult.attributeValue, VariableAttribute.value and EventData.actualValue. The max size of these values will always remain equal. */
    @Column(name = "value")
    private String value;


    @Column(name = "mutability")
    private MutabilityEnum mutability;


    /** If true, value will be persistent across system reboots or power down. Default when omitted is false. */
    @Column(name = "persistent")
    private Boolean persistent;


    /** If true, value that will never be changed by the Charging Station at runtime. Default when omitted is false. */
    @Column(name = "constant")
    private Boolean constant;


    @Column(name = "custom_data")
    private CustomData customData;

}
