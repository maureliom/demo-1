package com.example.demo.model.ocpp.schema.clear_display_message_request;

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
@Table(name = "clear_display_message_request")
public class ClearDisplayMessageRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Min(0)
    /** Id of the message that SHALL be removed from the Charging Station. */
    @Column(name = "id")
    private Integer id;

    @Min(0.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
