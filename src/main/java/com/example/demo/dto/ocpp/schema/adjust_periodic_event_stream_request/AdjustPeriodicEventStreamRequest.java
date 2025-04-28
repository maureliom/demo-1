package com.example.demo.dto.ocpp.schema.adjust_periodic_event_stream_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class AdjustPeriodicEventStreamRequest {


    @Min(0)
    @JsonProperty("id")
    private Integer id;

    @Min(0.0)

    @JsonProperty("params")
    private PeriodicEventStreamParams params;


    @JsonProperty("customData")
    private CustomData customData;

}
