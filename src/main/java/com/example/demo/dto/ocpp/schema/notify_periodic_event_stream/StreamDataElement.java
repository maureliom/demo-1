package com.example.demo.dto.ocpp.schema.notify_periodic_event_stream;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class StreamDataElement {


    /** Offset relative to _basetime_ of this message. _basetime_ + _t_ is timestamp of recorded value. */
    @JsonProperty("t")
    private Double t;


    @Size(max = 2500)
    @JsonProperty("v")
    private String v;


    @JsonProperty("customData")
    private CustomData customData;

}
