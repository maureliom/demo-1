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
public class TariffTimePrice {


    /** Price per minute (excl. tax) for this element. */
    @Column(name = "price_minute")
    private Double priceMinute;


    @Column(name = "conditions")
    private TariffConditions conditions;


    @Column(name = "custom_data")
    private CustomData customData;

}
