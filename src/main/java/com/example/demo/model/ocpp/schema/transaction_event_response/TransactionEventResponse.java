package com.example.demo.model.ocpp.schema.transaction_event_response;

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
@Table(name = "transaction_event_response")
public class TransactionEventResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    /** When _eventType_ of TransactionEventRequest is Updated, then this value contains the running cost. When _eventType_ of TransactionEventRequest is Ended, then this contains the final total cost of this transaction, including taxes, in the currency configured with the Configuration Variable: Currency. Absence of this value does not imply that the transaction was free. To indicate a free transaction, the CSMS SHALL send a value of 0.00. */
    @Column(name = "total_cost")
    private Double totalCost;


    /** Priority from a business point of view. Default priority is 0, The range is from -9 to 9. Higher values indicate a higher priority. The chargingPriority in &lt;&lt;transactioneventresponse,TransactionEventResponse&gt;&gt; is temporarily, so it may not be set in the &lt;&lt;cmn_idtokeninfotype,IdTokenInfoType&gt;&gt; afterwards. Also the chargingPriority in &lt;&lt;transactioneventresponse,TransactionEventResponse&gt;&gt; has a higher priority than the one in &lt;&lt;cmn_idtokeninfotype,IdTokenInfoType&gt;&gt;. */
    @Column(name = "charging_priority")
    private Integer chargingPriority;


    @Column(name = "id_token_info")
    private IdTokenInfo idTokenInfo;


    @Column(name = "transaction_limit")
    private TransactionLimit transactionLimit;


    @Column(name = "updated_personal_message")
    private MessageContent updatedPersonalMessage;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 4)
    @Column(name = "updated_personal_message_extra")
    private List<MessageContent> updatedPersonalMessageExtra;

    @ElementCollection
    private List<MessageContent> updatedPersonalMessageExtra = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
