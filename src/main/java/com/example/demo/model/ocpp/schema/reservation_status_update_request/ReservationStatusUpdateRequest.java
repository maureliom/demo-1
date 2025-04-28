package com.example.demo.model.ocpp.schema.reservation_status_update_request;

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
@Table(name = "reservation_status_update_request")
public class ReservationStatusUpdateRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Min(0)
    /** The ID of the reservation. */
    @Column(name = "reservation_id")
    private Integer reservationId;

    @Min(0.0)

    @Column(name = "reservation_update_status")
    private ReservationUpdateStatusEnum reservationUpdateStatus;


    @Column(name = "custom_data")
    private CustomData customData;

}
