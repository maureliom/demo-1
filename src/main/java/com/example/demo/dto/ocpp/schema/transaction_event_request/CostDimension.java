package com.example.demo.dto.ocpp.schema.transaction_event_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class CostDimension {


    @JsonProperty("type")
    private CostDimensionEnum type;


    /** Volume of the dimension consumed, measured according to the dimension type. */
    @JsonProperty("volume")
    private Double volume;


    @JsonProperty("customData")
    private CustomData customData;

}
