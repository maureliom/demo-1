package com.example.demo.model.ocpp.schema.get_transaction_status_request;

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
@Table(name = "get_transaction_status_request")
public class GetTransactionStatusRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Size(max = 36)
    /** The Id of the transaction for which the status is requested. */
    @Column(name = "transaction_id")
    private String transactionId;


    @Column(name = "custom_data")
    private CustomData customData;

}
