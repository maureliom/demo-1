package com.example.demo.model.ocpp.schema.trigger_message_request;

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
@Table(name = "trigger_message_request")
public class TriggerMessageRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "evse")
    private EVSE evse;


    @Column(name = "requested_message")
    private MessageTriggerEnum requestedMessage;


    @Size(max = 50)
    /** *(2.1)* When _requestedMessage_ = `CustomTrigger` this will trigger sending the corresponding message in field _customTrigger_, if supported by Charging Station. */
    @Column(name = "custom_trigger")
    private String customTrigger;


    @Column(name = "custom_data")
    private CustomData customData;

}
