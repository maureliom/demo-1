package com.example.demo.dto.ocpp.schema.notify_derstart_stop_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class NotifyDERStartStopRequest {


    @Size(max = 36)
    /** Id of the started or stopped DER control. Corresponds to the _controlId_ of the SetDERControlRequest. */
    @JsonProperty("controlId")
    private String controlId;


    /** True if DER control has started. False if it has ended. */
    @JsonProperty("started")
    private Boolean started;


    /** Time of start or end of event. */
    @JsonProperty("timestamp")
    private String timestamp;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 24)
    /** List of controlIds that are superseded as a result of this control starting. */
    @JsonProperty("supersededIds")
    private List<String> supersededIds;

    @JsonProperty("supersededIds")
    private List<String> supersededIds = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
