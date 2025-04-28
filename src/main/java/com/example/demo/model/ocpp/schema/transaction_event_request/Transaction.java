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
public class Transaction {


    @Size(max = 36)
    /** This contains the Id of the transaction. */
    @Column(name = "transaction_id")
    private String transactionId;


    @Column(name = "charging_state")
    private ChargingStateEnum chargingState;


    /** Contains the total time that energy flowed from EVSE to EV during the transaction (in seconds). Note that timeSpentCharging is smaller or equal to the duration of the transaction. */
    @Column(name = "time_spent_charging")
    private Integer timeSpentCharging;


    @Column(name = "stopped_reason")
    private ReasonEnum stoppedReason;


    /** The ID given to remote start request (&lt;&lt;requeststarttransactionrequest, RequestStartTransactionRequest&gt;&gt;. This enables to CSMS to match the started transaction to the given start request. */
    @Column(name = "remote_start_id")
    private Integer remoteStartId;


    @Column(name = "operation_mode")
    private OperationModeEnum operationMode;


    @Size(max = 60)
    /** *(2.1)* Id of tariff in use for transaction */
    @Column(name = "tariff_id")
    private String tariffId;


    @Column(name = "transaction_limit")
    private TransactionLimit transactionLimit;


    @Column(name = "custom_data")
    private CustomData customData;

}
