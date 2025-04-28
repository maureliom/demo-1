package com.example.demo.model.ocpp.schema.status_notification_request;

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
@Table(name = "status_notification_request")
public class StatusNotificationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    /** The time for which the status is reported. */
    @Column(name = "timestamp")
    private String timestamp;


    @Column(name = "connector_status")
    private ConnectorStatusEnum connectorStatus;


    @Min(0)
    /** The id of the EVSE to which the connector belongs for which the the status is reported. */
    @Column(name = "evse_id")
    private Integer evseId;

    @Min(0.0)

    @Min(0)
    /** The id of the connector within the EVSE for which the status is reported. */
    @Column(name = "connector_id")
    private Integer connectorId;

    @Min(0.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
