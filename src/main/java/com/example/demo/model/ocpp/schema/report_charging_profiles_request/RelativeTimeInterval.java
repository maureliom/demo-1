package com.example.demo.model.ocpp.schema.report_charging_profiles_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class RelativeTimeInterval {


    /** Start of the interval, in seconds from NOW. */
    @Column(name = "start")
    private Integer start;


    /** Duration of the interval, in seconds. */
    @Column(name = "duration")
    private Integer duration;


    @Column(name = "custom_data")
    private CustomData customData;

}
