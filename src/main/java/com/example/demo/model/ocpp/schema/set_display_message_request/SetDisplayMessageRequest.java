package com.example.demo.model.ocpp.schema.set_display_message_request;

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
@Table(name = "set_display_message_request")
public class SetDisplayMessageRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "message")
    private MessageInfo message;


    @Column(name = "custom_data")
    private CustomData customData;

}
