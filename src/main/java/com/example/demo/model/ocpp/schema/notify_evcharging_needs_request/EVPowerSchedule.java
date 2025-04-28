package com.example.demo.model.ocpp.schema.notify_evcharging_needs_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class EVPowerSchedule {


    @ElementCollection
    @Size(min = 1)
    @Size(max = 1024)
    @Column(name = "ev_power_schedule_entries")
    private List<EVPowerScheduleEntry> evPowerScheduleEntries;

    @ElementCollection
    private List<EVPowerScheduleEntry> evPowerScheduleEntries = new ArrayList<>();


    /** The time that defines the starting point for the EVEnergyOffer. */
    @Column(name = "time_anchor")
    private String timeAnchor;


    @Column(name = "custom_data")
    private CustomData customData;

}
