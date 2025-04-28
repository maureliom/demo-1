package com.example.demo.dto.ocpp.schema.reservation_status_update_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ReservationStatusUpdateRequest {


    @Min(0)
    /** The ID of the reservation. */
    @JsonProperty("reservationId")
    private Integer reservationId;

    @Min(0.0)

    @JsonProperty("reservationUpdateStatus")
    private ReservationUpdateStatusEnum reservationUpdateStatus;


    @JsonProperty("customData")
    private CustomData customData;

}
