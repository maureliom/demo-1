package com.example.demo.dto.ocpp.schema.request_start_transaction_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class V2XFreqWattPoint {


    /** Net frequency in Hz. */
    @JsonProperty("frequency")
    private Double frequency;


    /** Power in W to charge (positive) or discharge (negative) at specified frequency. */
    @JsonProperty("power")
    private Double power;


    @JsonProperty("customData")
    private CustomData customData;

}
