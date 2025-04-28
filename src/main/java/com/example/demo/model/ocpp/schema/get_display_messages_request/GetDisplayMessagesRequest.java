package com.example.demo.model.ocpp.schema.get_display_messages_request;

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
@Table(name = "get_display_messages_request")
public class GetDisplayMessagesRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @ElementCollection
    @Size(min = 1)
    /** If provided the Charging Station shall return Display Messages of the given ids. This field SHALL NOT contain more ids than set in &lt;&lt;configkey-number-of-display-messages,NumberOfDisplayMessages.maxLimit&gt;&gt; */
    @Column(name = "id")
    private List<Integer> id;

    @ElementCollection
    private List<Integer> id = new ArrayList<>();


    /** The Id of this request. */
    @Column(name = "request_id")
    private Integer requestId;


    @Column(name = "priority")
    private MessagePriorityEnum priority;


    @Column(name = "state")
    private MessageStateEnum state;


    @Column(name = "custom_data")
    private CustomData customData;

}
