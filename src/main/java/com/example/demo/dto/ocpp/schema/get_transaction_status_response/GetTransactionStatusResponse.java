package com.example.demo.dto.ocpp.schema.get_transaction_status_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetTransactionStatusResponse {


    /** Whether the transaction is still ongoing. */
    @JsonProperty("ongoingIndicator")
    private Boolean ongoingIndicator;


    /** Whether there are still message to be delivered. */
    @JsonProperty("messagesInQueue")
    private Boolean messagesInQueue;


    @JsonProperty("customData")
    private CustomData customData;

}
