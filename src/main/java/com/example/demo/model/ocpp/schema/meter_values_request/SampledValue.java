package com.example.demo.model.ocpp.schema.meter_values_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class SampledValue {


    /** Indicates the measured value. */
    @Column(name = "value")
    private Double value;


    @Column(name = "measurand")
    private MeasurandEnum measurand;


    @Column(name = "context")
    private ReadingContextEnum context;


    @Column(name = "phase")
    private PhaseEnum phase;


    @Column(name = "location")
    private LocationEnum location;


    @Column(name = "signed_meter_value")
    private SignedMeterValue signedMeterValue;


    @Column(name = "unit_of_measure")
    private UnitOfMeasure unitOfMeasure;


    @Column(name = "custom_data")
    private CustomData customData;

}
