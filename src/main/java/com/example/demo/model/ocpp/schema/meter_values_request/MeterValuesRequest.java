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
@Entity
@Table(name = "meter_values_request")
public class MeterValuesRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Min(0)
    /** This contains a number (&gt;0) designating an EVSE of the Charging Station. ‘0’ (zero) is used to designate the main power meter. */
    @Column(name = "evse_id")
    private Integer evseId;

    @Min(0.0)

    @ElementCollection
    @Size(min = 1)
    @Column(name = "meter_value")
    private List<MeterValue> meterValue;

    @ElementCollection
    private List<MeterValue> meterValue = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
