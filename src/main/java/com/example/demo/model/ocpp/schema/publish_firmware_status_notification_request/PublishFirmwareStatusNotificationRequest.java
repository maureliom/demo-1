package com.example.demo.model.ocpp.schema.publish_firmware_status_notification_request;

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
@Table(name = "publish_firmware_status_notification_request")
public class PublishFirmwareStatusNotificationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "status")
    private PublishFirmwareStatusEnum status;


    @ElementCollection
    @Size(min = 1)
    /** Required if status is Published. Can be multiple URI’s, if the Local Controller supports e.g. HTTP, HTTPS, and FTP. */
    @Column(name = "location")
    private List<String> location;

    @ElementCollection
    private List<String> location = new ArrayList<>();


    @Min(0)
    /** The request id that was provided in the PublishFirmwareRequest which triggered this action. */
    @Column(name = "request_id")
    private Integer requestId;

    @Min(0.0)

    @Column(name = "status_info")
    private StatusInfo statusInfo;


    @Column(name = "custom_data")
    private CustomData customData;

}
