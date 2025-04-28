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
public class SalesTariff {


    @Min(0)
    /** SalesTariff identifier used to identify one sales tariff. An SAID remains a unique identifier for one schedule throughout a charging session. */
    @Column(name = "id")
    private Integer id;

    @Min(0.0)

    @Size(max = 32)
    /** A human readable title/short description of the sales tariff e.g. for HMI display purposes. */
    @Column(name = "sales_tariff_description")
    private String salesTariffDescription;


    @Min(0)
    /** Defines the overall number of distinct price levels used across all provided SalesTariff elements. */
    @Column(name = "num_eprice_levels")
    private Integer numEPriceLevels;

    @Min(0.0)

    @ElementCollection
    @Size(min = 1)
    @Size(max = 1024)
    @Column(name = "sales_tariff_entry")
    private List<SalesTariffEntry> salesTariffEntry;

    @ElementCollection
    private List<SalesTariffEntry> salesTariffEntry = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
