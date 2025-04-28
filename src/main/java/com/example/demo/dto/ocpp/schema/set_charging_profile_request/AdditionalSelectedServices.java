package com.example.demo.dto.ocpp.schema.set_charging_profile_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class AdditionalSelectedServices {


    @JsonProperty("serviceFee")
    private RationalNumber serviceFee;


    @Size(max = 80)
    /** Human readable string to identify this service. */
    @JsonProperty("serviceName")
    private String serviceName;


    @JsonProperty("customData")
    private CustomData customData;

}
