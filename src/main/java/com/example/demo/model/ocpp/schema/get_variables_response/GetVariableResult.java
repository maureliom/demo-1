package com.example.demo.model.ocpp.schema.get_variables_response;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetVariableResult {


    @Column(name = "attribute_status")
    private GetVariableStatusEnum attributeStatus;


    @Column(name = "attribute_status_info")
    private StatusInfo attributeStatusInfo;


    @Column(name = "attribute_type")
    private AttributeEnum attributeType;


    @Size(max = 2500)
    /** Value of requested attribute type of component-variable. This field can only be empty when the given status is NOT accepted. The Configuration Variable &lt;&lt;configkey-reporting-value-size,ReportingValueSize&gt;&gt; can be used to limit GetVariableResult.attributeValue, VariableAttribute.value and EventData.actualValue. The max size of these values will always remain equal. */
    @Column(name = "attribute_value")
    private String attributeValue;


    @Column(name = "component")
    private Component component;


    @Column(name = "variable")
    private Variable variable;


    @Column(name = "custom_data")
    private CustomData customData;

}
