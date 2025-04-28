package com.example.demo.dto.ocpp.schema.notify_periodic_event_stream;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class NotifyPeriodicEventStream {


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("data")
    private List<StreamDataElement> data;

    @JsonProperty("data")
    private List<StreamDataElement> data = new ArrayList<>();


    @Min(0)
    /** Id of stream. */
    @JsonProperty("id")
    private Integer id;

    @Min(0.0)

    @Min(0)
    /** Number of data elements still pending to be sent. */
    @JsonProperty("pending")
    private Integer pending;

    @Min(0.0)

    /** Base timestamp to add to time offset of values. */
    @JsonProperty("basetime")
    private String basetime;


    @JsonProperty("customData")
    private CustomData customData;

}
