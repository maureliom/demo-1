package com.example.demo.dto.ocpp.schema.request_battery_swap_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class CustomData {


    @Size(max = 255)
    @JsonProperty("vendorId")
    private String vendorId;

}
