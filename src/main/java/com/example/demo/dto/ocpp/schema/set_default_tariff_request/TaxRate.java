package com.example.demo.dto.ocpp.schema.set_default_tariff_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class TaxRate {


    @Size(max = 20)
    /** Type of this tax, e.g. \"Federal \", \"State\", for information on receipt. */
    @JsonProperty("type")
    private String type;


    /** Tax percentage */
    @JsonProperty("tax")
    private Double tax;


    @Min(0)
    /** Stack level for this type of tax. Default value, when absent, is 0. + _stack_ = 0: tax on net price; + _stack_ = 1: tax added on top of _stack_ 0; + _stack_ = 2: tax added on top of _stack_ 1, etc. */
    @JsonProperty("stack")
    private Integer stack;

    @Min(0.0)

    @JsonProperty("customData")
    private CustomData customData;

}
