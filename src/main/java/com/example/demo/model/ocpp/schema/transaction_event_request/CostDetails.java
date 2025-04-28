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
public class CostDetails {


    @ElementCollection
    @Size(min = 1)
    @Column(name = "charging_periods")
    private List<ChargingPeriod> chargingPeriods;

    @ElementCollection
    private List<ChargingPeriod> chargingPeriods = new ArrayList<>();


    @Column(name = "total_cost")
    private TotalCost totalCost;


    @Column(name = "total_usage")
    private TotalUsage totalUsage;


    /** If set to true, then Charging Station has failed to calculate the cost. */
    @Column(name = "failure_to_calculate")
    private Boolean failureToCalculate;


    @Size(max = 500)
    /** Optional human-readable reason text in case of failure to calculate. */
    @Column(name = "failure_reason")
    private String failureReason;


    @Column(name = "custom_data")
    private CustomData customData;

}
