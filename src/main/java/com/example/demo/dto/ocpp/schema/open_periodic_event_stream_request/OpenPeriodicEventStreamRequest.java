package com.example.demo.dto.ocpp.schema.open_periodic_event_stream_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class OpenPeriodicEventStreamRequest {


    @JsonProperty("constantStreamData")
    private ConstantStreamData constantStreamData;


    @JsonProperty("customData")
    private CustomData customData;

}
