package com.example.demo.model.ocpp.schema.get_transaction_status_response;

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
@Table(name = "get_transaction_status_response")
public class GetTransactionStatusResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    /** Whether the transaction is still ongoing. */
    @Column(name = "ongoing_indicator")
    private Boolean ongoingIndicator;


    /** Whether there are still message to be delivered. */
    @Column(name = "messages_in_queue")
    private Boolean messagesInQueue;


    @Column(name = "custom_data")
    private CustomData customData;

}
