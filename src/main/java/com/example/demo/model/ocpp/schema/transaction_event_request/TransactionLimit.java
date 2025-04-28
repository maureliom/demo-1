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
public class TransactionLimit {


    /** Maximum allowed cost of transaction in currency of tariff. */
    @Column(name = "max_cost")
    private Double maxCost;


    /** Maximum allowed energy in Wh to charge in transaction. */
    @Column(name = "max_energy")
    private Double maxEnergy;


    /** Maximum duration of transaction in seconds from start to end. */
    @Column(name = "max_time")
    private Integer maxTime;


    @Min(0)
    @Max(100)
    /** Maximum State of Charge of EV in percentage. */
    @Column(name = "max_so_c")
    private Integer maxSoC;

    @Min(0.0)
    @Max(100.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
