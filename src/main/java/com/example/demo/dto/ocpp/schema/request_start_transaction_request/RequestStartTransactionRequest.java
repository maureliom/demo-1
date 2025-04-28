package com.example.demo.dto.ocpp.schema.request_start_transaction_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class RequestStartTransactionRequest {


    @Min(1)
    /** Number of the EVSE on which to start the transaction. EvseId SHALL be &gt; 0 */
    @JsonProperty("evseId")
    private Integer evseId;

    @Min(1.0)

    @JsonProperty("groupIdToken")
    private IdToken groupIdToken;


    @JsonProperty("idToken")
    private IdToken idToken;


    /** Id given by the server to this start request. The Charging Station will return this in the &lt;&lt;transactioneventrequest, TransactionEventRequest&gt;&gt;, letting the server know which transaction was started for this request. Use to start a transaction. */
    @JsonProperty("remoteStartId")
    private Integer remoteStartId;


    @JsonProperty("chargingProfile")
    private ChargingProfile chargingProfile;


    @JsonProperty("customData")
    private CustomData customData;

}
