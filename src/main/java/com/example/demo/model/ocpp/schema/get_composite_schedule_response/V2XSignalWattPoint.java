package com.example.demo.model.ocpp.schema.get_composite_schedule_response;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class V2XSignalWattPoint {


    /** Signal value from an AFRRSignalRequest. */
    @Column(name = "signal")
    private Integer signal;


    /** Power in W to charge (positive) or discharge (negative) at specified frequency. */
    @Column(name = "power")
    private Double power;


    @Column(name = "custom_data")
    private CustomData customData;

}
