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
public class TariffConditions {


    /** Start time of day in local time. + Format as per RFC 3339: time-hour \":\" time-minute + Must be in 24h format with leading zeros. Hour/Minute separator: \":\" Regex: ([0-1][0-9]\|2[0-3]):[0-5][0-9] */
    @Column(name = "start_time_of_day")
    private String startTimeOfDay;


    /** End time of day in local time. Same syntax as _startTimeOfDay_. + If end time &lt; start time then the period wraps around to the next day. + To stop at end of the day use: 00:00. */
    @Column(name = "end_time_of_day")
    private String endTimeOfDay;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 7)
    /** Day(s) of the week this is tariff applies. */
    @Column(name = "day_of_week")
    private List<DayOfWeekEnum> dayOfWeek;

    @ElementCollection
    private List<DayOfWeekEnum> dayOfWeek = new ArrayList<>();


    /** Start date in local time, for example: 2015-12-24. Valid from this day (inclusive). + Format as per RFC 3339: full-date + Regex: ([12][0-9]{3})-(0[1-9]\|1[0-2])-(0[1-9]\|[12][0-9]\|3[01]) */
    @Column(name = "valid_from_date")
    private String validFromDate;


    /** End date in local time, for example: 2015-12-27. Valid until this day (exclusive). Same syntax as _validFromDate_. */
    @Column(name = "valid_to_date")
    private String validToDate;


    @Column(name = "evse_kind")
    private EvseKindEnum evseKind;


    /** Minimum consumed energy in Wh, for example 20000 Wh. Valid from this amount of energy (inclusive) being used. */
    @Column(name = "min_energy")
    private Double minEnergy;


    /** Maximum consumed energy in Wh, for example 50000 Wh. Valid until this amount of energy (exclusive) being used. */
    @Column(name = "max_energy")
    private Double maxEnergy;


    /** Sum of the minimum current (in Amperes) over all phases, for example 5 A. When the EV is charging with more than, or equal to, the defined amount of current, this price is/becomes active. If the charging current is or becomes lower, this price is not or no longer valid and becomes inactive. + This is NOT about the minimum current over the entire transaction. */
    @Column(name = "min_current")
    private Double minCurrent;


    /** Sum of the maximum current (in Amperes) over all phases, for example 20 A. When the EV is charging with less than the defined amount of current, this price becomes/is active. If the charging current is or becomes higher, this price is not or no longer valid and becomes inactive. This is NOT about the maximum current over the entire transaction. */
    @Column(name = "max_current")
    private Double maxCurrent;


    /** Minimum power in W, for example 5000 W. When the EV is charging with more than, or equal to, the defined amount of power, this price is/becomes active. If the charging power is or becomes lower, this price is not or no longer valid and becomes inactive. This is NOT about the minimum power over the entire transaction. */
    @Column(name = "min_power")
    private Double minPower;


    /** Maximum power in W, for example 20000 W. When the EV is charging with less than the defined amount of power, this price becomes/is active. If the charging power is or becomes higher, this price is not or no longer valid and becomes inactive. This is NOT about the maximum power over the entire transaction. */
    @Column(name = "max_power")
    private Double maxPower;


    /** Minimum duration in seconds the transaction (charging &amp; idle) MUST last (inclusive). When the duration of a transaction is longer than the defined value, this price is or becomes active. Before that moment, this price is not yet active. */
    @Column(name = "min_time")
    private Integer minTime;


    /** Maximum duration in seconds the transaction (charging &amp; idle) MUST last (exclusive). When the duration of a transaction is shorter than the defined value, this price is or becomes active. After that moment, this price is no longer active. */
    @Column(name = "max_time")
    private Integer maxTime;


    /** Minimum duration in seconds the charging MUST last (inclusive). When the duration of a charging is longer than the defined value, this price is or becomes active. Before that moment, this price is not yet active. */
    @Column(name = "min_charging_time")
    private Integer minChargingTime;


    /** Maximum duration in seconds the charging MUST last (exclusive). When the duration of a charging is shorter than the defined value, this price is or becomes active. After that moment, this price is no longer active. */
    @Column(name = "max_charging_time")
    private Integer maxChargingTime;


    /** Minimum duration in seconds the idle period (i.e. not charging) MUST last (inclusive). When the duration of the idle time is longer than the defined value, this price is or becomes active. Before that moment, this price is not yet active. */
    @Column(name = "min_idle_time")
    private Integer minIdleTime;


    /** Maximum duration in seconds the idle period (i.e. not charging) MUST last (exclusive). When the duration of idle time is shorter than the defined value, this price is or becomes active. After that moment, this price is no longer active. */
    @Column(name = "max_idle_time")
    private Integer maxIdleTime;


    @Column(name = "custom_data")
    private CustomData customData;

}
