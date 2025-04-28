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
public class MeterValue {


    @ElementCollection
    @Size(min = 1)
    @Column(name = "sampled_value")
    private List<SampledValue> sampledValue;

    @ElementCollection
    private List<SampledValue> sampledValue = new ArrayList<>();


    /** Timestamp for measured value(s). */
    @Column(name = "timestamp")
    private String timestamp;


    @Column(name = "custom_data")
    private CustomData customData;

}
