package com.example.demo.model.ocpp.schema.report_dercontrol_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class Gradient {


    @Min(0)
    /** Id of setting */
    @Column(name = "priority")
    private Integer priority;

    @Min(0.0)

    /** Default ramp rate in seconds (0 if not applicable) */
    @Column(name = "gradient")
    private Double gradient;


    /** Soft-start ramp rate in seconds (0 if not applicable) */
    @Column(name = "soft_gradient")
    private Double softGradient;


    @Column(name = "custom_data")
    private CustomData customData;

}
