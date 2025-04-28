package com.example.demo.dto.ocpp.schema.request_start_transaction_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class RequestStartTransactionResponse {


    @JsonProperty("status")
    private RequestStartStopStatusEnum status;


    @JsonProperty("statusInfo")
    private StatusInfo statusInfo;


    @Size(max = 36)
    /** When the transaction was already started by the Charging Station before the RequestStartTransactionRequest was received, for example: cable plugged in first. This contains the transactionId of the already started transaction. */
    @JsonProperty("transactionId")
    private String transactionId;


    @JsonProperty("customData")
    private CustomData customData;

}
