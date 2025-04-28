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
public class EVEnergyOffer {


    @Column(name = "ev_absolute_price_schedule")
    private EVAbsolutePriceSchedule evAbsolutePriceSchedule;


    @Column(name = "ev_power_schedule")
    private EVPowerSchedule evPowerSchedule;


    @Column(name = "custom_data")
    private CustomData customData;

}
