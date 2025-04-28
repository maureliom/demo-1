package com.example.demo.dto.ocpp.schema.send_local_list_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class IdTokenInfo {


    @JsonProperty("status")
    private AuthorizationStatusEnum status;


    /** Date and Time after which the token must be considered invalid. */
    @JsonProperty("cacheExpiryDateTime")
    private String cacheExpiryDateTime;


    /** Priority from a business point of view. Default priority is 0, The range is from -9 to 9. Higher values indicate a higher priority. The chargingPriority in &lt;&lt;transactioneventresponse,TransactionEventResponse&gt;&gt; overrules this one. */
    @JsonProperty("chargingPriority")
    private Integer chargingPriority;


    @JsonProperty("groupIdToken")
    private IdToken groupIdToken;


    @Size(max = 8)
    /** Preferred user interface language of identifier user. Contains a language code as defined in &lt;&lt;ref-RFC5646,[RFC5646]&gt;&gt;. */
    @JsonProperty("language1")
    private String language1;


    @Size(max = 8)
    /** Second preferred user interface language of identifier user. Don’t use when language1 is omitted, has to be different from language1. Contains a language code as defined in &lt;&lt;ref-RFC5646,[RFC5646]&gt;&gt;. */
    @JsonProperty("language2")
    private String language2;


    @ElementCollection
    @Size(min = 1)
    /** Only used when the IdToken is only valid for one or more specific EVSEs, not for the entire Charging Station. */
    @JsonProperty("evseId")
    private List<Integer> evseId;

    @JsonProperty("evseId")
    private List<Integer> evseId = new ArrayList<>();


    @JsonProperty("personalMessage")
    private MessageContent personalMessage;


    @JsonProperty("customData")
    private CustomData customData;

}
