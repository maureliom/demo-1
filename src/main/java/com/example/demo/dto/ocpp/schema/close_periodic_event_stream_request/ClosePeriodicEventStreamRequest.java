package com.example.demo.dto.ocpp.schema.close_periodic_event_stream_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ClosePeriodicEventStreamRequest {


    @Min(0)
    /** Id of stream to close. */
    @JsonProperty("id")
    private Integer id;

    @Min(0.0)

    @JsonProperty("customData")
    private CustomData customData;

}
