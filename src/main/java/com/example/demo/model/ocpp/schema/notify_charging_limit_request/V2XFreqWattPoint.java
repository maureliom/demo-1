package com.example.demo.model.ocpp.schema.notify_charging_limit_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class V2XFreqWattPoint {


    /** Net frequency in Hz. */
    @Column(name = "frequency")
    private Double frequency;


    /** Power in W to charge (positive) or discharge (negative) at specified frequency. */
    @Column(name = "power")
    private Double power;


    @Column(name = "custom_data")
    private CustomData customData;

}
