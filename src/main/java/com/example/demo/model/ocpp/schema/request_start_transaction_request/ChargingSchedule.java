package com.example.demo.model.ocpp.schema.request_start_transaction_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ChargingSchedule {


    @Column(name = "id")
    private Integer id;


    @Column(name = "limit_at_so_c")
    private LimitAtSoC limitAtSoC;


    /** Starting point of an absolute schedule or recurring schedule. */
    @Column(name = "start_schedule")
    private String startSchedule;


    /** Duration of the charging schedule in seconds. If the duration is left empty, the last period will continue indefinitely or until end of the transaction in case startSchedule is absent. */
    @Column(name = "duration")
    private Integer duration;


    @Column(name = "charging_rate_unit")
    private ChargingRateUnitEnum chargingRateUnit;


    /** Minimum charging rate supported by the EV. The unit of measure is defined by the chargingRateUnit. This parameter is intended to be used by a local smart charging algorithm to optimize the power allocation for in the case a charging process is inefficient at lower charging rates. */
    @Column(name = "min_charging_rate")
    private Double minChargingRate;


    /** *(2.1)* Power tolerance when following EVPowerProfile. */
    @Column(name = "power_tolerance")
    private Double powerTolerance;


    @Min(0)
    /** *(2.1)* Id of this element for referencing in a signature. */
    @Column(name = "signature_id")
    private Integer signatureId;

    @Min(0.0)

    @Size(max = 88)
    /** *(2.1)* Base64 encoded hash (SHA256 for ISO 15118-2, SHA512 for ISO 15118-20) of the EXI price schedule element. Used in signature. */
    @Column(name = "digest_value")
    private String digestValue;


    /** *(2.1)* Defaults to false. When true, disregard time zone offset in dateTime fields of _ChargingScheduleType_ and use unqualified local time at Charging Station instead. This allows the same `Absolute` or `Recurring` charging profile to be used in both summer and winter time. */
    @Column(name = "use_local_time")
    private Boolean useLocalTime;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 1024)
    @Column(name = "charging_schedule_period")
    private List<ChargingSchedulePeriod> chargingSchedulePeriod;

    @ElementCollection
    private List<ChargingSchedulePeriod> chargingSchedulePeriod = new ArrayList<>();


    @Min(0)
    /** *(2.1)* Defaults to 0. When _randomizedDelay_ not equals zero, then the start of each &lt;&lt;cmn_chargingscheduleperiodtype,ChargingSchedulePeriodType&gt;&gt; is delayed by a randomly chosen number of seconds between 0 and _randomizedDelay_. Only allowed for TxProfile and TxDefaultProfile. */
    @Column(name = "randomized_delay")
    private Integer randomizedDelay;

    @Min(0.0)

    @Column(name = "sales_tariff")
    private SalesTariff salesTariff;


    @Column(name = "absolute_price_schedule")
    private AbsolutePriceSchedule absolutePriceSchedule;


    @Column(name = "price_level_schedule")
    private PriceLevelSchedule priceLevelSchedule;


    @Column(name = "custom_data")
    private CustomData customData;

}
