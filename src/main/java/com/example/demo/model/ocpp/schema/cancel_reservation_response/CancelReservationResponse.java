package com.example.demo.model.ocpp.schema.cancel_reservation_response;

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
@Table(name = "cancel_reservation_response")
public class CancelReservationResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "status")
    private CancelReservationStatusEnum status;


    @Column(name = "status_info")
    private StatusInfo statusInfo;


    @Column(name = "custom_data")
    private CustomData customData;

}
