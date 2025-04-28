package com.example.demo.dto.ocpp.schema.transaction_event_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class SampledValue {


    /** Indicates the measured value. */
    @JsonProperty("value")
    private Double value;


    @JsonProperty("measurand")
    private MeasurandEnum measurand;


    @JsonProperty("context")
    private ReadingContextEnum context;


    @JsonProperty("phase")
    private PhaseEnum phase;


    @JsonProperty("location")
    private LocationEnum location;


    @JsonProperty("signedMeterValue")
    private SignedMeterValue signedMeterValue;


    @JsonProperty("unitOfMeasure")
    private UnitOfMeasure unitOfMeasure;


    @JsonProperty("customData")
    private CustomData customData;

}
