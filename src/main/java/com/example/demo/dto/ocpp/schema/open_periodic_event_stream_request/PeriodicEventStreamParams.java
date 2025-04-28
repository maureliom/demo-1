package com.example.demo.dto.ocpp.schema.open_periodic_event_stream_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class PeriodicEventStreamParams {


    @Min(0)
    /** Time in seconds after which stream data is sent. */
    @JsonProperty("interval")
    private Integer interval;

    @Min(0.0)

    @Min(0)
    /** Number of items to be sent together in stream. */
    @JsonProperty("values")
    private Integer values;

    @Min(0.0)

    @JsonProperty("customData")
    private CustomData customData;

}
