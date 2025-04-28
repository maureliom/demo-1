package com.example.demo.dto.ocpp.schema.report_charging_profiles_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class RationalNumber {


    /** The exponent to base 10 (dec) */
    @JsonProperty("exponent")
    private Integer exponent;


    /** Value which shall be multiplied. */
    @JsonProperty("value")
    private Integer value;


    @JsonProperty("customData")
    private CustomData customData;

}
