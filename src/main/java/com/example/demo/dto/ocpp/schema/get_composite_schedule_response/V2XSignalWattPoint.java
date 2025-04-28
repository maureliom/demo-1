package com.example.demo.dto.ocpp.schema.get_composite_schedule_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class V2XSignalWattPoint {


    /** Signal value from an AFRRSignalRequest. */
    @JsonProperty("signal")
    private Integer signal;


    /** Power in W to charge (positive) or discharge (negative) at specified frequency. */
    @JsonProperty("power")
    private Double power;


    @JsonProperty("customData")
    private CustomData customData;

}
