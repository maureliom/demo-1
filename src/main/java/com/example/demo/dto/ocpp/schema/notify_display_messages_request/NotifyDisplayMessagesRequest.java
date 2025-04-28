package com.example.demo.dto.ocpp.schema.notify_display_messages_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class NotifyDisplayMessagesRequest {


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("messageInfo")
    private List<MessageInfo> messageInfo;

    @JsonProperty("messageInfo")
    private List<MessageInfo> messageInfo = new ArrayList<>();


    /** The id of the &lt;&lt;getdisplaymessagesrequest,GetDisplayMessagesRequest&gt;&gt; that requested this message. */
    @JsonProperty("requestId")
    private Integer requestId;


    /** \"to be continued\" indicator. Indicates whether another part of the report follows in an upcoming NotifyDisplayMessagesRequest message. Default value when omitted is false. */
    @JsonProperty("tbc")
    private Boolean tbc;


    @JsonProperty("customData")
    private CustomData customData;

}
