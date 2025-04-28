package com.example.demo.dto.ocpp.schema.set_dercontrol_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class Gradient {


    @Min(0)
    /** Id of setting */
    @JsonProperty("priority")
    private Integer priority;

    @Min(0.0)

    /** Default ramp rate in seconds (0 if not applicable) */
    @JsonProperty("gradient")
    private Double gradient;


    /** Soft-start ramp rate in seconds (0 if not applicable) */
    @JsonProperty("softGradient")
    private Double softGradient;


    @JsonProperty("customData")
    private CustomData customData;

}
