package com.example.demo.dto.ocpp.schema.cancel_reservation_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class CancelReservationRequest {


    @Min(0)
    /** Id of the reservation to cancel. */
    @JsonProperty("reservationId")
    private Integer reservationId;

    @Min(0.0)

    @JsonProperty("customData")
    private CustomData customData;

}
