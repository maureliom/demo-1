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
public class AdditionalInfo {


    @Size(max = 255)
    /** *(2.1)* This field specifies the additional IdToken. */
    @Column(name = "additional_id_token")
    private String additionalIdToken;


    @Size(max = 50)
    /** _additionalInfo_ can be used to send extra information to CSMS in addition to the regular authorization with _IdToken_. _AdditionalInfo_ contains one or more custom _types_, which need to be agreed upon by all parties involved. When the _type_ is not supported, the CSMS/Charging Station MAY ignore the _additionalInfo_. */
    @Column(name = "type")
    private String type;


    @Column(name = "custom_data")
    private CustomData customData;

}
