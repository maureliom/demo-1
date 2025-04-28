package com.example.demo.dto.ocpp.schema.request_start_transaction_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class SalesTariff {


    @Min(0)
    /** SalesTariff identifier used to identify one sales tariff. An SAID remains a unique identifier for one schedule throughout a charging session. */
    @JsonProperty("id")
    private Integer id;

    @Min(0.0)

    @Size(max = 32)
    /** A human readable title/short description of the sales tariff e.g. for HMI display purposes. */
    @JsonProperty("salesTariffDescription")
    private String salesTariffDescription;


    @Min(0)
    /** Defines the overall number of distinct price levels used across all provided SalesTariff elements. */
    @JsonProperty("numEPriceLevels")
    private Integer numEPriceLevels;

    @Min(0.0)

    @ElementCollection
    @Size(min = 1)
    @Size(max = 1024)
    @JsonProperty("salesTariffEntry")
    private List<SalesTariffEntry> salesTariffEntry;

    @JsonProperty("salesTariffEntry")
    private List<SalesTariffEntry> salesTariffEntry = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
