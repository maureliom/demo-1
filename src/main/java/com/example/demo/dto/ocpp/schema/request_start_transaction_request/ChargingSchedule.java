package com.example.demo.dto.ocpp.schema.request_start_transaction_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ChargingSchedule {


    @JsonProperty("id")
    private Integer id;


    @JsonProperty("limitAtSoC")
    private LimitAtSoC limitAtSoC;


    /** Starting point of an absolute schedule or recurring schedule. */
    @JsonProperty("startSchedule")
    private String startSchedule;


    /** Duration of the charging schedule in seconds. If the duration is left empty, the last period will continue indefinitely or until end of the transaction in case startSchedule is absent. */
    @JsonProperty("duration")
    private Integer duration;


    @JsonProperty("chargingRateUnit")
    private ChargingRateUnitEnum chargingRateUnit;


    /** Minimum charging rate supported by the EV. The unit of measure is defined by the chargingRateUnit. This parameter is intended to be used by a local smart charging algorithm to optimize the power allocation for in the case a charging process is inefficient at lower charging rates. */
    @JsonProperty("minChargingRate")
    private Double minChargingRate;


    /** *(2.1)* Power tolerance when following EVPowerProfile. */
    @JsonProperty("powerTolerance")
    private Double powerTolerance;


    @Min(0)
    /** *(2.1)* Id of this element for referencing in a signature. */
    @JsonProperty("signatureId")
    private Integer signatureId;

    @Min(0.0)

    @Size(max = 88)
    /** *(2.1)* Base64 encoded hash (SHA256 for ISO 15118-2, SHA512 for ISO 15118-20) of the EXI price schedule element. Used in signature. */
    @JsonProperty("digestValue")
    private String digestValue;


    /** *(2.1)* Defaults to false. When true, disregard time zone offset in dateTime fields of _ChargingScheduleType_ and use unqualified local time at Charging Station instead. This allows the same `Absolute` or `Recurring` charging profile to be used in both summer and winter time. */
    @JsonProperty("useLocalTime")
    private Boolean useLocalTime;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 1024)
    @JsonProperty("chargingSchedulePeriod")
    private List<ChargingSchedulePeriod> chargingSchedulePeriod;

    @JsonProperty("chargingSchedulePeriod")
    private List<ChargingSchedulePeriod> chargingSchedulePeriod = new ArrayList<>();


    @Min(0)
    /** *(2.1)* Defaults to 0. When _randomizedDelay_ not equals zero, then the start of each &lt;&lt;cmn_chargingscheduleperiodtype,ChargingSchedulePeriodType&gt;&gt; is delayed by a randomly chosen number of seconds between 0 and _randomizedDelay_. Only allowed for TxProfile and TxDefaultProfile. */
    @JsonProperty("randomizedDelay")
    private Integer randomizedDelay;

    @Min(0.0)

    @JsonProperty("salesTariff")
    private SalesTariff salesTariff;


    @JsonProperty("absolutePriceSchedule")
    private AbsolutePriceSchedule absolutePriceSchedule;


    @JsonProperty("priceLevelSchedule")
    private PriceLevelSchedule priceLevelSchedule;


    @JsonProperty("customData")
    private CustomData customData;

}
