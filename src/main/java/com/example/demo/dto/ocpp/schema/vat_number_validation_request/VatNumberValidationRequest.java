package com.example.demo.dto.ocpp.schema.vat_number_validation_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class VatNumberValidationRequest {


    @Size(max = 20)
    /** VAT number to check. */
    @JsonProperty("vatNumber")
    private String vatNumber;


    @Min(0)
    /** EVSE id for which check is done */
    @JsonProperty("evseId")
    private Integer evseId;

    @Min(0.0)

    @JsonProperty("customData")
    private CustomData customData;

}
