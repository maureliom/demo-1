package com.example.demo.dto.ocpp.schema.transaction_event_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class Transaction {


    @Size(max = 36)
    /** This contains the Id of the transaction. */
    @JsonProperty("transactionId")
    private String transactionId;


    @JsonProperty("chargingState")
    private ChargingStateEnum chargingState;


    /** Contains the total time that energy flowed from EVSE to EV during the transaction (in seconds). Note that timeSpentCharging is smaller or equal to the duration of the transaction. */
    @JsonProperty("timeSpentCharging")
    private Integer timeSpentCharging;


    @JsonProperty("stoppedReason")
    private ReasonEnum stoppedReason;


    /** The ID given to remote start request (&lt;&lt;requeststarttransactionrequest, RequestStartTransactionRequest&gt;&gt;. This enables to CSMS to match the started transaction to the given start request. */
    @JsonProperty("remoteStartId")
    private Integer remoteStartId;


    @JsonProperty("operationMode")
    private OperationModeEnum operationMode;


    @Size(max = 60)
    /** *(2.1)* Id of tariff in use for transaction */
    @JsonProperty("tariffId")
    private String tariffId;


    @JsonProperty("transactionLimit")
    private TransactionLimit transactionLimit;


    @JsonProperty("customData")
    private CustomData customData;

}
