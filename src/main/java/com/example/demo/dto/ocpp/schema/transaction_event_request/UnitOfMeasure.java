package com.example.demo.dto.ocpp.schema.transaction_event_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class UnitOfMeasure {


    @Size(max = 20)
    /** Unit of the value. Default = \"Wh\" if the (default) measurand is an \"Energy\" type. This field SHALL use a value from the list Standardized Units of Measurements in Part 2 Appendices. If an applicable unit is available in that list, otherwise a \"custom\" unit might be used. */
    @JsonProperty("unit")
    private String unit;


    /** Multiplier, this value represents the exponent to base 10. I.e. multiplier 3 means 10 raised to the 3rd power. Default is 0. + The _multiplier_ only multiplies the value of the measurand. It does not specify a conversion between units, for example, kW and W. */
    @JsonProperty("multiplier")
    private Integer multiplier;


    @JsonProperty("customData")
    private CustomData customData;

}
