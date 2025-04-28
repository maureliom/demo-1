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
public class ReportData {


    @Column(name = "component")
    private Component component;


    @Column(name = "variable")
    private Variable variable;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 4)
    @Column(name = "variable_attribute")
    private List<VariableAttribute> variableAttribute;

    @ElementCollection
    private List<VariableAttribute> variableAttribute = new ArrayList<>();


    @Column(name = "variable_characteristics")
    private VariableCharacteristics variableCharacteristics;


    @Column(name = "custom_data")
    private CustomData customData;

}
