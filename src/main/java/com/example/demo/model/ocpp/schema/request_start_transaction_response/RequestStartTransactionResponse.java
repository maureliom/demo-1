package com.example.demo.model.ocpp.schema.request_start_transaction_response;

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
@Table(name = "request_start_transaction_response")
public class RequestStartTransactionResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "status")
    private RequestStartStopStatusEnum status;


    @Column(name = "status_info")
    private StatusInfo statusInfo;


    @Size(max = 36)
    /** When the transaction was already started by the Charging Station before the RequestStartTransactionRequest was received, for example: cable plugged in first. This contains the transactionId of the already started transaction. */
    @Column(name = "transaction_id")
    private String transactionId;


    @Column(name = "custom_data")
    private CustomData customData;

}
