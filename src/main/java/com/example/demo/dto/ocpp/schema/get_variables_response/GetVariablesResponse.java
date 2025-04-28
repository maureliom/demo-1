package com.example.demo.dto.ocpp.schema.get_variables_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetVariablesResponse {


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("getVariableResult")
    private List<GetVariableResult> getVariableResult;

    @JsonProperty("getVariableResult")
    private List<GetVariableResult> getVariableResult = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
