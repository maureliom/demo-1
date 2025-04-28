package com.example.demo.dto.ocpp.schema.transaction_event_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class TotalPrice {


    /** Price/cost excluding tax. Can be absent if _inclTax_ is present. */
    @JsonProperty("exclTax")
    private Double exclTax;


    /** Price/cost including tax. Can be absent if _exclTax_ is present. */
    @JsonProperty("inclTax")
    private Double inclTax;


    @JsonProperty("customData")
    private CustomData customData;

}
