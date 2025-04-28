package com.example.demo.dto.ocpp.schema.set_variables_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class SetVariablesResponse {


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("setVariableResult")
    private List<SetVariableResult> setVariableResult;

    @JsonProperty("setVariableResult")
    private List<SetVariableResult> setVariableResult = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
