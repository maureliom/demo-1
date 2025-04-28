package com.example.demo.model.ocpp.schema.notify_display_messages_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class MessageContent {


    @Column(name = "format")
    private MessageFormatEnum format;


    @Size(max = 8)
    /** Message language identifier. Contains a language code as defined in &lt;&lt;ref-RFC5646,[RFC5646]&gt;&gt;. */
    @Column(name = "language")
    private String language;


    @Size(max = 1024)
    /** *(2.1)* Required. Message contents. + Maximum length supported by Charging Station is given in OCPPCommCtrlr.FieldLength[\"MessageContentType.content\"]. Maximum length defaults to 1024. */
    @Column(name = "content")
    private String content;


    @Column(name = "custom_data")
    private CustomData customData;

}
