package com.example.demo.dto.ocpp.schema.set_variables_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class SetVariablesRequest {


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("setVariableData")
    private List<SetVariableData> setVariableData;

    @JsonProperty("setVariableData")
    private List<SetVariableData> setVariableData = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
