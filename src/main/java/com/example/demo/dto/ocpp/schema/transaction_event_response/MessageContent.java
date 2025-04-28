package com.example.demo.dto.ocpp.schema.transaction_event_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class MessageContent {


    @JsonProperty("format")
    private MessageFormatEnum format;


    @Size(max = 8)
    /** Message language identifier. Contains a language code as defined in &lt;&lt;ref-RFC5646,[RFC5646]&gt;&gt;. */
    @JsonProperty("language")
    private String language;


    @Size(max = 1024)
    /** *(2.1)* Required. Message contents. + Maximum length supported by Charging Station is given in OCPPCommCtrlr.FieldLength[\"MessageContentType.content\"]. Maximum length defaults to 1024. */
    @JsonProperty("content")
    private String content;


    @JsonProperty("customData")
    private CustomData customData;

}
