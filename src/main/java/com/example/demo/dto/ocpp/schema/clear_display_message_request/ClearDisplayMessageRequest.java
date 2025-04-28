package com.example.demo.dto.ocpp.schema.clear_display_message_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ClearDisplayMessageRequest {


    @Min(0)
    /** Id of the message that SHALL be removed from the Charging Station. */
    @JsonProperty("id")
    private Integer id;

    @Min(0.0)

    @JsonProperty("customData")
    private CustomData customData;

}
