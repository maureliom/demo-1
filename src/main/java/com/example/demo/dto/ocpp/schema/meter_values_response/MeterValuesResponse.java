package com.example.demo.dto.ocpp.schema.meter_values_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class MeterValuesResponse {


    @JsonProperty("customData")
    private CustomData customData;

}
