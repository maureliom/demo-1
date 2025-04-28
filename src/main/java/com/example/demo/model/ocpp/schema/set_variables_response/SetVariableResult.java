package com.example.demo.model.ocpp.schema.set_variables_response;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class SetVariableResult {


    @Column(name = "attribute_type")
    private AttributeEnum attributeType;


    @Column(name = "attribute_status")
    private SetVariableStatusEnum attributeStatus;


    @Column(name = "attribute_status_info")
    private StatusInfo attributeStatusInfo;


    @Column(name = "component")
    private Component component;


    @Column(name = "variable")
    private Variable variable;


    @Column(name = "custom_data")
    private CustomData customData;

}
