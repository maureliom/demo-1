package com.example.demo.dto.ocpp.schema.transaction_event_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class IdToken {


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("additionalInfo")
    private List<AdditionalInfo> additionalInfo;

    @JsonProperty("additionalInfo")
    private List<AdditionalInfo> additionalInfo = new ArrayList<>();


    @Size(max = 255)
    /** *(2.1)* IdToken is case insensitive. Might hold the hidden id of an RFID tag, but can for example also contain a UUID. */
    @JsonProperty("idToken")
    private String idToken;


    @Size(max = 20)
    /** *(2.1)* Enumeration of possible idToken types. Values defined in Appendix as IdTokenEnumStringType. */
    @JsonProperty("type")
    private String type;


    @JsonProperty("customData")
    private CustomData customData;

}
