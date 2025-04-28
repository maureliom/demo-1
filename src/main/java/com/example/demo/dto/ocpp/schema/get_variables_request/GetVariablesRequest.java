package com.example.demo.dto.ocpp.schema.get_variables_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetVariablesRequest {


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("getVariableData")
    private List<GetVariableData> getVariableData;

    @JsonProperty("getVariableData")
    private List<GetVariableData> getVariableData = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
