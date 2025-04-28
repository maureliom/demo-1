package com.example.demo.dto.ocpp.schema.vat_number_validation_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class VatNumberValidationResponse {


    @JsonProperty("company")
    private Address company;


    @JsonProperty("statusInfo")
    private StatusInfo statusInfo;


    @Size(max = 20)
    /** VAT number that was requested. */
    @JsonProperty("vatNumber")
    private String vatNumber;


    @Min(0)
    /** EVSE id for which check was requested. */
    @JsonProperty("evseId")
    private Integer evseId;

    @Min(0.0)

    @JsonProperty("status")
    private GenericStatusEnum status;


    @JsonProperty("customData")
    private CustomData customData;

}
