package com.example.demo.model.ocpp.schema.notify_charging_limit_request;

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
@Table(name = "notify_charging_limit_request")
public class NotifyChargingLimitRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @ElementCollection
    @Size(min = 1)
    @Column(name = "charging_schedule")
    private List<ChargingSchedule> chargingSchedule;

    @ElementCollection
    private List<ChargingSchedule> chargingSchedule = new ArrayList<>();


    @Min(0)
    /** The EVSE to which the charging limit is set. If absent or when zero, it applies to the entire Charging Station. */
    @Column(name = "evse_id")
    private Integer evseId;

    @Min(0.0)

    @Column(name = "charging_limit")
    private ChargingLimit chargingLimit;


    @Column(name = "custom_data")
    private CustomData customData;

}
