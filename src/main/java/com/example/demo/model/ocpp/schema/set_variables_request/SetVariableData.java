package com.example.demo.model.ocpp.schema.set_variables_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class SetVariableData {


    @Column(name = "attribute_type")
    private AttributeEnum attributeType;


    @Size(max = 2500)
    /** Value to be assigned to attribute of variable. This value is allowed to be an empty string (\"\"). The Configuration Variable &lt;&lt;configkey-configuration-value-size,ConfigurationValueSize&gt;&gt; can be used to limit SetVariableData.attributeValue and VariableCharacteristics.valuesList. The max size of these values will always remain equal. */
    @Column(name = "attribute_value")
    private String attributeValue;


    @Column(name = "component")
    private Component component;


    @Column(name = "variable")
    private Variable variable;


    @Column(name = "custom_data")
    private CustomData customData;

}
