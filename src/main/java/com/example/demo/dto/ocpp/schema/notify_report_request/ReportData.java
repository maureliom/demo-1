package com.example.demo.dto.ocpp.schema.notify_report_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ReportData {


    @JsonProperty("component")
    private Component component;


    @JsonProperty("variable")
    private Variable variable;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 4)
    @JsonProperty("variableAttribute")
    private List<VariableAttribute> variableAttribute;

    @JsonProperty("variableAttribute")
    private List<VariableAttribute> variableAttribute = new ArrayList<>();


    @JsonProperty("variableCharacteristics")
    private VariableCharacteristics variableCharacteristics;


    @JsonProperty("customData")
    private CustomData customData;

}
