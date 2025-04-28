package com.example.demo.model.ocpp.schema.get_composite_schedule_response;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class CompositeSchedule {


    @Min(0)
    @Column(name = "evse_id")
    private Integer evseId;

    @Min(0.0)

    @Column(name = "duration")
    private Integer duration;


    @Column(name = "schedule_start")
    private String scheduleStart;


    @Column(name = "charging_rate_unit")
    private ChargingRateUnitEnum chargingRateUnit;


    @ElementCollection
    @Size(min = 1)
    @Column(name = "charging_schedule_period")
    private List<ChargingSchedulePeriod> chargingSchedulePeriod;

    @ElementCollection
    private List<ChargingSchedulePeriod> chargingSchedulePeriod = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
