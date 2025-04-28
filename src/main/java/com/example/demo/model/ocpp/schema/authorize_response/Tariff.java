package com.example.demo.model.ocpp.schema.authorize_response;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class Tariff {


    @Size(max = 60)
    /** Unique id of tariff */
    @Column(name = "tariff_id")
    private String tariffId;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 10)
    @Column(name = "description")
    private List<MessageContent> description;

    @ElementCollection
    private List<MessageContent> description = new ArrayList<>();


    @Size(max = 3)
    /** Currency code according to ISO 4217 */
    @Column(name = "currency")
    private String currency;


    @Column(name = "energy")
    private TariffEnergy energy;


    /** Time when this tariff becomes active. When absent, it is immediately active. */
    @Column(name = "valid_from")
    private String validFrom;


    @Column(name = "charging_time")
    private TariffTime chargingTime;


    @Column(name = "idle_time")
    private TariffTime idleTime;


    @Column(name = "fixed_fee")
    private TariffFixed fixedFee;


    @Column(name = "reservation_time")
    private TariffTime reservationTime;


    @Column(name = "reservation_fixed")
    private TariffFixed reservationFixed;


    @Column(name = "min_cost")
    private Price minCost;


    @Column(name = "max_cost")
    private Price maxCost;


    @Column(name = "custom_data")
    private CustomData customData;

}
