package com.example.demo.model.ocpp.schema.transaction_event_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class TotalUsage {


    @Column(name = "energy")
    private Double energy;


    /** Total duration of the charging session (including the duration of charging and not charging), in seconds. */
    @Column(name = "charging_time")
    private Integer chargingTime;


    /** Total duration of the charging session where the EV was not charging (no energy was transferred between EVSE and EV), in seconds. */
    @Column(name = "idle_time")
    private Integer idleTime;


    /** Total time of reservation in seconds. */
    @Column(name = "reservation_time")
    private Integer reservationTime;


    @Column(name = "custom_data")
    private CustomData customData;

}
