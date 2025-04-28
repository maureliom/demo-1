package com.example.demo.model.ocpp.schema.authorize_response;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class IdTokenInfo {


    @Column(name = "status")
    private AuthorizationStatusEnum status;


    /** Date and Time after which the token must be considered invalid. */
    @Column(name = "cache_expiry_date_time")
    private String cacheExpiryDateTime;


    /** Priority from a business point of view. Default priority is 0, The range is from -9 to 9. Higher values indicate a higher priority. The chargingPriority in &lt;&lt;transactioneventresponse,TransactionEventResponse&gt;&gt; overrules this one. */
    @Column(name = "charging_priority")
    private Integer chargingPriority;


    @Column(name = "group_id_token")
    private IdToken groupIdToken;


    @Size(max = 8)
    /** Preferred user interface language of identifier user. Contains a language code as defined in &lt;&lt;ref-RFC5646,[RFC5646]&gt;&gt;. */
    @Column(name = "language1")
    private String language1;


    @Size(max = 8)
    /** Second preferred user interface language of identifier user. Don’t use when language1 is omitted, has to be different from language1. Contains a language code as defined in &lt;&lt;ref-RFC5646,[RFC5646]&gt;&gt;. */
    @Column(name = "language2")
    private String language2;


    @ElementCollection
    @Size(min = 1)
    /** Only used when the IdToken is only valid for one or more specific EVSEs, not for the entire Charging Station. */
    @Column(name = "evse_id")
    private List<Integer> evseId;

    @ElementCollection
    private List<Integer> evseId = new ArrayList<>();


    @Column(name = "personal_message")
    private MessageContent personalMessage;


    @Column(name = "custom_data")
    private CustomData customData;

}
