package com.example.demo.model.ocpp.schema.set_charging_profile_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class AdditionalSelectedServices {


    @Column(name = "service_fee")
    private RationalNumber serviceFee;


    @Size(max = 80)
    /** Human readable string to identify this service. */
    @Column(name = "service_name")
    private String serviceName;


    @Column(name = "custom_data")
    private CustomData customData;

}
