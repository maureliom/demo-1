package com.example.demo.dto.ocpp.schema.afrrsignal_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class AFRRSignalRequest {


    /** Time when signal becomes active. */
    @JsonProperty("timestamp")
    private String timestamp;


    /** Value of signal in _v2xSignalWattCurve_. */
    @JsonProperty("signal")
    private Integer signal;


    @JsonProperty("customData")
    private CustomData customData;

}
