package com.example.demo.dto.ocpp.schema.transaction_event_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class TransactionEventResponse {


    /** When _eventType_ of TransactionEventRequest is Updated, then this value contains the running cost. When _eventType_ of TransactionEventRequest is Ended, then this contains the final total cost of this transaction, including taxes, in the currency configured with the Configuration Variable: Currency. Absence of this value does not imply that the transaction was free. To indicate a free transaction, the CSMS SHALL send a value of 0.00. */
    @JsonProperty("totalCost")
    private Double totalCost;


    /** Priority from a business point of view. Default priority is 0, The range is from -9 to 9. Higher values indicate a higher priority. The chargingPriority in &lt;&lt;transactioneventresponse,TransactionEventResponse&gt;&gt; is temporarily, so it may not be set in the &lt;&lt;cmn_idtokeninfotype,IdTokenInfoType&gt;&gt; afterwards. Also the chargingPriority in &lt;&lt;transactioneventresponse,TransactionEventResponse&gt;&gt; has a higher priority than the one in &lt;&lt;cmn_idtokeninfotype,IdTokenInfoType&gt;&gt;. */
    @JsonProperty("chargingPriority")
    private Integer chargingPriority;


    @JsonProperty("idTokenInfo")
    private IdTokenInfo idTokenInfo;


    @JsonProperty("transactionLimit")
    private TransactionLimit transactionLimit;


    @JsonProperty("updatedPersonalMessage")
    private MessageContent updatedPersonalMessage;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 4)
    @JsonProperty("updatedPersonalMessageExtra")
    private List<MessageContent> updatedPersonalMessageExtra;

    @JsonProperty("updatedPersonalMessageExtra")
    private List<MessageContent> updatedPersonalMessageExtra = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
