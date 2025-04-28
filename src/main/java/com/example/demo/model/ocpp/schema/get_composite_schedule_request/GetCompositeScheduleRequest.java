package com.example.demo.model.ocpp.schema.get_composite_schedule_request;

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
@Table(name = "get_composite_schedule_request")
public class GetCompositeScheduleRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    /** Length of the requested schedule in seconds. */
    @Column(name = "duration")
    private Integer duration;


    @Column(name = "charging_rate_unit")
    private ChargingRateUnitEnum chargingRateUnit;


    @Min(0)
    /** The ID of the EVSE for which the schedule is requested. When evseid=0, the Charging Station will calculate the expected consumption for the grid connection. */
    @Column(name = "evse_id")
    private Integer evseId;

    @Min(0.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
