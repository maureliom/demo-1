package com.example.demo.model.ocpp.schema.cost_updated_request;

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
@Table(name = "cost_updated_request")
public class CostUpdatedRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    /** Current total cost, based on the information known by the CSMS, of the transaction including taxes. In the currency configured with the configuration Variable: [&lt;&lt;configkey-currency, Currency&gt;&gt;] */
    @Column(name = "total_cost")
    private Double totalCost;


    @Size(max = 36)
    /** Transaction Id of the transaction the current cost are asked for. */
    @Column(name = "transaction_id")
    private String transactionId;


    @Column(name = "custom_data")
    private CustomData customData;

}
