package com.example.demo.dto.ocpp.schema.clear_tariffs_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ClearTariffsResponse {


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("clearTariffsResult")
    private List<ClearTariffsResult> clearTariffsResult;

    @JsonProperty("clearTariffsResult")
    private List<ClearTariffsResult> clearTariffsResult = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
