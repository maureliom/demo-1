package com.example.demo.dto.ocpp.schema.change_transaction_tariff_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class Tariff {


    @Size(max = 60)
    /** Unique id of tariff */
    @JsonProperty("tariffId")
    private String tariffId;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 10)
    @JsonProperty("description")
    private List<MessageContent> description;

    @JsonProperty("description")
    private List<MessageContent> description = new ArrayList<>();


    @Size(max = 3)
    /** Currency code according to ISO 4217 */
    @JsonProperty("currency")
    private String currency;


    @JsonProperty("energy")
    private TariffEnergy energy;


    /** Time when this tariff becomes active. When absent, it is immediately active. */
    @JsonProperty("validFrom")
    private String validFrom;


    @JsonProperty("chargingTime")
    private TariffTime chargingTime;


    @JsonProperty("idleTime")
    private TariffTime idleTime;


    @JsonProperty("fixedFee")
    private TariffFixed fixedFee;


    @JsonProperty("reservationTime")
    private TariffTime reservationTime;


    @JsonProperty("reservationFixed")
    private TariffFixed reservationFixed;


    @JsonProperty("minCost")
    private Price minCost;


    @JsonProperty("maxCost")
    private Price maxCost;


    @JsonProperty("customData")
    private CustomData customData;

}
