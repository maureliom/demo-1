package com.example.demo.model.ocpp.schema.transaction_event_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class CostDimension {


    @Column(name = "type")
    private CostDimensionEnum type;


    /** Volume of the dimension consumed, measured according to the dimension type. */
    @Column(name = "volume")
    private Double volume;


    @Column(name = "custom_data")
    private CustomData customData;

}
