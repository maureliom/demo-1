package com.example.demo.model.ocpp.schema.firmware_status_notification_request;

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
@Table(name = "firmware_status_notification_request")
public class FirmwareStatusNotificationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "status")
    private FirmwareStatusEnum status;


    /** The request id that was provided in the UpdateFirmwareRequest that started this firmware update. This field is mandatory, unless the message was triggered by a TriggerMessageRequest AND there is no firmware update ongoing. */
    @Column(name = "request_id")
    private Integer requestId;


    @Column(name = "status_info")
    private StatusInfo statusInfo;


    @Column(name = "custom_data")
    private CustomData customData;

}
