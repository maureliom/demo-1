package com.example.demo.model.ocpp.schema.notify_priority_charging_request;

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
@Table(name = "notify_priority_charging_request")
public class NotifyPriorityChargingRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Size(max = 36)
    /** The transaction for which priority charging is requested. */
    @Column(name = "transaction_id")
    private String transactionId;


    /** True if priority charging was activated. False if it has stopped using the priority charging profile. */
    @Column(name = "activated")
    private Boolean activated;


    @Column(name = "custom_data")
    private CustomData customData;

}
