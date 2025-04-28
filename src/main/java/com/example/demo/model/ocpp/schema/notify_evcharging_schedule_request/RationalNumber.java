package com.example.demo.model.ocpp.schema.notify_evcharging_schedule_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class RationalNumber {


    /** The exponent to base 10 (dec) */
    @Column(name = "exponent")
    private Integer exponent;


    /** Value which shall be multiplied. */
    @Column(name = "value")
    private Integer value;


    @Column(name = "custom_data")
    private CustomData customData;

}
