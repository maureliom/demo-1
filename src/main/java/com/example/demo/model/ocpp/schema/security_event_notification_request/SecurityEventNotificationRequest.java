package com.example.demo.model.ocpp.schema.security_event_notification_request;

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
@Table(name = "security_event_notification_request")
public class SecurityEventNotificationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Size(max = 50)
    /** Type of the security event. This value should be taken from the Security events list. */
    @Column(name = "type")
    private String type;


    /** Date and time at which the event occurred. */
    @Column(name = "timestamp")
    private String timestamp;


    @Size(max = 255)
    /** Additional information about the occurred security event. */
    @Column(name = "tech_info")
    private String techInfo;


    @Column(name = "custom_data")
    private CustomData customData;

}
