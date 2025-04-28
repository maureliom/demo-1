package com.example.demo.dto.ocpp.schema.notify_display_messages_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class MessageInfo {


    @JsonProperty("display")
    private Component display;


    @Min(0)
    /** Unique id within an exchange context. It is defined within the OCPP context as a positive Integer value (greater or equal to zero). */
    @JsonProperty("id")
    private Integer id;

    @Min(0.0)

    @JsonProperty("priority")
    private MessagePriorityEnum priority;


    @JsonProperty("state")
    private MessageStateEnum state;


    /** From what date-time should this message be shown. If omitted: directly. */
    @JsonProperty("startDateTime")
    private String startDateTime;


    /** Until what date-time should this message be shown, after this date/time this message SHALL be removed. */
    @JsonProperty("endDateTime")
    private String endDateTime;


    @Size(max = 36)
    /** During which transaction shall this message be shown. Message SHALL be removed by the Charging Station after transaction has ended. */
    @JsonProperty("transactionId")
    private String transactionId;


    @JsonProperty("message")
    private MessageContent message;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 4)
    @JsonProperty("messageExtra")
    private List<MessageContent> messageExtra;

    @JsonProperty("messageExtra")
    private List<MessageContent> messageExtra = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
