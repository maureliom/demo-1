package com.example.demo.model.ocpp.schema.send_local_list_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class IdToken {


    @ElementCollection
    @Size(min = 1)
    @Column(name = "additional_info")
    private List<AdditionalInfo> additionalInfo;

    @ElementCollection
    private List<AdditionalInfo> additionalInfo = new ArrayList<>();


    @Size(max = 255)
    /** *(2.1)* IdToken is case insensitive. Might hold the hidden id of an RFID tag, but can for example also contain a UUID. */
    @Column(name = "id_token")
    private String idToken;


    @Size(max = 20)
    /** *(2.1)* Enumeration of possible idToken types. Values defined in Appendix as IdTokenEnumStringType. */
    @Column(name = "type")
    private String type;


    @Column(name = "custom_data")
    private CustomData customData;

}
