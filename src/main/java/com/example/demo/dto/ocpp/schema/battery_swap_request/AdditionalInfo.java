package com.example.demo.dto.ocpp.schema.battery_swap_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class AdditionalInfo {


    @Size(max = 255)
    /** *(2.1)* This field specifies the additional IdToken. */
    @JsonProperty("additionalIdToken")
    private String additionalIdToken;


    @Size(max = 50)
    /** _additionalInfo_ can be used to send extra information to CSMS in addition to the regular authorization with _IdToken_. _AdditionalInfo_ contains one or more custom _types_, which need to be agreed upon by all parties involved. When the _type_ is not supported, the CSMS/Charging Station MAY ignore the _additionalInfo_. */
    @JsonProperty("type")
    private String type;


    @JsonProperty("customData")
    private CustomData customData;

}
