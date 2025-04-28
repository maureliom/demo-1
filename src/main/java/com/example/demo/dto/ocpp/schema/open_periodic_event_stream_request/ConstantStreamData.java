package com.example.demo.dto.ocpp.schema.open_periodic_event_stream_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ConstantStreamData {


    @Min(0)
    /** Uniquely identifies the stream */
    @JsonProperty("id")
    private Integer id;

    @Min(0.0)

    @JsonProperty("params")
    private PeriodicEventStreamParams params;


    @Min(0)
    /** Id of monitor used to report his event. It can be a preconfigured or hardwired monitor. */
    @JsonProperty("variableMonitoringId")
    private Integer variableMonitoringId;

    @Min(0.0)

    @JsonProperty("customData")
    private CustomData customData;

}
