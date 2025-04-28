package com.example.demo.model.ocpp.schema.set_default_tariff_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class TariffConditionsFixed {


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


    @Size(max = 20)
    /** For which payment brand this (adhoc) tariff applies. Can be used to add a surcharge for certain payment brands. Based on value of _additionalIdToken_ from _idToken.additionalInfo.type_ = \"PaymentBrand\". */
    @Column(name = "payment_brand")
    private String paymentBrand;


    @Size(max = 20)
    /** Type of adhoc payment, e.g. CC, Debit. Based on value of _additionalIdToken_ from _idToken.additionalInfo.type_ = \"PaymentRecognition\". */
    @Column(name = "payment_recognition")
    private String paymentRecognition;


    @Column(name = "custom_data")
    private CustomData customData;

}
