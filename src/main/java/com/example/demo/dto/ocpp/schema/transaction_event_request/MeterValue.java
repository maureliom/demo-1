package com.example.demo.dto.ocpp.schema.transaction_event_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class MeterValue {


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("sampledValue")
    private List<SampledValue> sampledValue;

    @JsonProperty("sampledValue")
    private List<SampledValue> sampledValue = new ArrayList<>();


    /** Timestamp for measured value(s). */
    @JsonProperty("timestamp")
    private String timestamp;


    @JsonProperty("customData")
    private CustomData customData;

}
