package com.example.demo.model.ocpp.schema.boot_notification_request;

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
@Table(name = "boot_notification_request")
public class BootNotificationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "charging_station")
    private ChargingStation chargingStation;


    @Column(name = "reason")
    private BootReasonEnum reason;


    @Column(name = "custom_data")
    private CustomData customData;

}
