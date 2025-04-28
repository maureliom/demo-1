package com.example.demo.model.ocpp.schema.notify_evcharging_schedule_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ConsumptionCost {


    /** The lowest level of consumption that defines the starting point of this consumption block. The block interval extends to the start of the next interval. */
    @Column(name = "start_value")
    private Double startValue;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 3)
    @Column(name = "cost")
    private List<Cost> cost;

    @ElementCollection
    private List<Cost> cost = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
