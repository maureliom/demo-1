package com.example.demo.model.ocpp.schema.notify_display_messages_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "notify_display_messages_request")
public class NotifyDisplayMessagesRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @ElementCollection
    @Size(min = 1)
    @Column(name = "message_info")
    private List<MessageInfo> messageInfo;

    @ElementCollection
    private List<MessageInfo> messageInfo = new ArrayList<>();


    /** The id of the &lt;&lt;getdisplaymessagesrequest,GetDisplayMessagesRequest&gt;&gt; that requested this message. */
    @Column(name = "request_id")
    private Integer requestId;


    /** \"to be continued\" indicator. Indicates whether another part of the report follows in an upcoming NotifyDisplayMessagesRequest message. Default value when omitted is false. */
    @Column(name = "tbc")
    private Boolean tbc;


    @Column(name = "custom_data")
    private CustomData customData;

}
