package com.example.demo.dto.ocpp.schema.request_stop_transaction_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class RequestStopTransactionRequest {


    @Size(max = 36)
    /** The identifier of the transaction which the Charging Station is requested to stop. */
    @JsonProperty("transactionId")
    private String transactionId;


    @JsonProperty("customData")
    private CustomData customData;

}
