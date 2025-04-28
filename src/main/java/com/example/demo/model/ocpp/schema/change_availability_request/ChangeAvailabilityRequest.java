package com.example.demo.model.ocpp.schema.change_availability_request;

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
@Table(name = "change_availability_request")
public class ChangeAvailabilityRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "evse")
    private EVSE evse;


    @Column(name = "operational_status")
    private OperationalStatusEnum operationalStatus;


    @Column(name = "custom_data")
    private CustomData customData;

}
