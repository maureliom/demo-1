package com.example.demo.model.ocpp.schema.change_transaction_tariff_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class TariffFixedPrice {


    @Column(name = "conditions")
    private TariffConditionsFixed conditions;


    /** Fixed price for this element e.g. a start fee. */
    @Column(name = "price_fixed")
    private Double priceFixed;


    @Column(name = "custom_data")
    private CustomData customData;

}
