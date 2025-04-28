package com.example.demo.dto.ocpp.schema.get_transaction_status_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetTransactionStatusRequest {


    @Size(max = 36)
    /** The Id of the transaction for which the status is requested. */
    @JsonProperty("transactionId")
    private String transactionId;


    @JsonProperty("customData")
    private CustomData customData;

}
