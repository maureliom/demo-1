package com.example.demo.model.ocpp.schema.cancel_reservation_request;

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
@Table(name = "cancel_reservation_request")
public class CancelReservationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Min(0)
    /** Id of the reservation to cancel. */
    @Column(name = "reservation_id")
    private Integer reservationId;

    @Min(0.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
