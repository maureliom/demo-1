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
public class TotalCost {


    @Size(max = 3)
    /** Currency of the costs in ISO 4217 Code. */
    @Column(name = "currency")
    private String currency;


    @Column(name = "type_of_cost")
    private TariffCostEnum typeOfCost;


    @Column(name = "fixed")
    private Price fixed;


    @Column(name = "energy")
    private Price energy;


    @Column(name = "charging_time")
    private Price chargingTime;


    @Column(name = "idle_time")
    private Price idleTime;


    @Column(name = "reservation_time")
    private Price reservationTime;


    @Column(name = "reservation_fixed")
    private Price reservationFixed;


    @Column(name = "total")
    private TotalPrice total;


    @Column(name = "custom_data")
    private CustomData customData;

}
