package com.example.demo.model.ocpp.schema.request_start_transaction_request;

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
@Table(name = "request_start_transaction_request")
public class RequestStartTransactionRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Min(1)
    /** Number of the EVSE on which to start the transaction. EvseId SHALL be &gt; 0 */
    @Column(name = "evse_id")
    private Integer evseId;

    @Min(1.0)

    @Column(name = "group_id_token")
    private IdToken groupIdToken;


    @Column(name = "id_token")
    private IdToken idToken;


    /** Id given by the server to this start request. The Charging Station will return this in the &lt;&lt;transactioneventrequest, TransactionEventRequest&gt;&gt;, letting the server know which transaction was started for this request. Use to start a transaction. */
    @Column(name = "remote_start_id")
    private Integer remoteStartId;


    @Column(name = "charging_profile")
    private ChargingProfile chargingProfile;


    @Column(name = "custom_data")
    private CustomData customData;

}
