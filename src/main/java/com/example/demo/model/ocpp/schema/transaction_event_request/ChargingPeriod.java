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
public class ChargingPeriod {


    @ElementCollection
    @Size(min = 1)
    @Column(name = "dimensions")
    private List<CostDimension> dimensions;

    @ElementCollection
    private List<CostDimension> dimensions = new ArrayList<>();


    @Size(max = 60)
    /** Unique identifier of the Tariff that was used to calculate cost. If not provided, then cost was calculated by some other means. */
    @Column(name = "tariff_id")
    private String tariffId;


    /** Start timestamp of charging period. A period ends when the next period starts. The last period ends when the session ends. */
    @Column(name = "start_period")
    private String startPeriod;


    @Column(name = "custom_data")
    private CustomData customData;

}
