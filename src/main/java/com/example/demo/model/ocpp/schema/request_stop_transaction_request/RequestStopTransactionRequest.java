package com.example.demo.model.ocpp.schema.request_stop_transaction_request;

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
@Table(name = "request_stop_transaction_request")
public class RequestStopTransactionRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Size(max = 36)
    /** The identifier of the transaction which the Charging Station is requested to stop. */
    @Column(name = "transaction_id")
    private String transactionId;


    @Column(name = "custom_data")
    private CustomData customData;

}
