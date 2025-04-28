package com.example.demo.dto.ocpp.schema.get_display_messages_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetDisplayMessagesRequest {


    @ElementCollection
    @Size(min = 1)
    /** If provided the Charging Station shall return Display Messages of the given ids. This field SHALL NOT contain more ids than set in &lt;&lt;configkey-number-of-display-messages,NumberOfDisplayMessages.maxLimit&gt;&gt; */
    @JsonProperty("id")
    private List<Integer> id;

    @JsonProperty("id")
    private List<Integer> id = new ArrayList<>();


    /** The Id of this request. */
    @JsonProperty("requestId")
    private Integer requestId;


    @JsonProperty("priority")
    private MessagePriorityEnum priority;


    @JsonProperty("state")
    private MessageStateEnum state;


    @JsonProperty("customData")
    private CustomData customData;

}
