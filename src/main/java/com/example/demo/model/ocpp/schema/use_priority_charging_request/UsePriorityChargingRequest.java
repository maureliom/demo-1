package com.example.demo.model.ocpp.schema.use_priority_charging_request;

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
@Table(name = "use_priority_charging_request")
public class UsePriorityChargingRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Size(max = 36)
    /** The transaction for which priority charging is requested. */
    @Column(name = "transaction_id")
    private String transactionId;


    /** True to request priority charging. False to request stopping priority charging. */
    @Column(name = "activate")
    private Boolean activate;


    @Column(name = "custom_data")
    private CustomData customData;

}
