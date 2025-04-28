package com.example.demo.dto.ocpp.schema.get_periodic_event_stream_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetPeriodicEventStreamResponse {


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("constantStreamData")
    private List<ConstantStreamData> constantStreamData;

    @JsonProperty("constantStreamData")
    private List<ConstantStreamData> constantStreamData = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
