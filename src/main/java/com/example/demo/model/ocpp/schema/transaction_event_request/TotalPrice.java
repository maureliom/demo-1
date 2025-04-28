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
public class TotalPrice {


    /** Price/cost excluding tax. Can be absent if _inclTax_ is present. */
    @Column(name = "excl_tax")
    private Double exclTax;


    /** Price/cost including tax. Can be absent if _exclTax_ is present. */
    @Column(name = "incl_tax")
    private Double inclTax;


    @Column(name = "custom_data")
    private CustomData customData;

}
