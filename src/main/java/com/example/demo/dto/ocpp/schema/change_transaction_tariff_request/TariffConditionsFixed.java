package com.example.demo.dto.ocpp.schema.change_transaction_tariff_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class TariffConditionsFixed {


    /** Start time of day in local time. + Format as per RFC 3339: time-hour \":\" time-minute + Must be in 24h format with leading zeros. Hour/Minute separator: \":\" Regex: ([0-1][0-9]\|2[0-3]):[0-5][0-9] */
    @JsonProperty("startTimeOfDay")
    private String startTimeOfDay;


    /** End time of day in local time. Same syntax as _startTimeOfDay_. + If end time &lt; start time then the period wraps around to the next day. + To stop at end of the day use: 00:00. */
    @JsonProperty("endTimeOfDay")
    private String endTimeOfDay;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 7)
    /** Day(s) of the week this is tariff applies. */
    @JsonProperty("dayOfWeek")
    private List<DayOfWeekEnum> dayOfWeek;

    @JsonProperty("dayOfWeek")
    private List<DayOfWeekEnum> dayOfWeek = new ArrayList<>();


    /** Start date in local time, for example: 2015-12-24. Valid from this day (inclusive). + Format as per RFC 3339: full-date + Regex: ([12][0-9]{3})-(0[1-9]\|1[0-2])-(0[1-9]\|[12][0-9]\|3[01]) */
    @JsonProperty("validFromDate")
    private String validFromDate;


    /** End date in local time, for example: 2015-12-27. Valid until this day (exclusive). Same syntax as _validFromDate_. */
    @JsonProperty("validToDate")
    private String validToDate;


    @JsonProperty("evseKind")
    private EvseKindEnum evseKind;


    @Size(max = 20)
    /** For which payment brand this (adhoc) tariff applies. Can be used to add a surcharge for certain payment brands. Based on value of _additionalIdToken_ from _idToken.additionalInfo.type_ = \"PaymentBrand\". */
    @JsonProperty("paymentBrand")
    private String paymentBrand;


    @Size(max = 20)
    /** Type of adhoc payment, e.g. CC, Debit. Based on value of _additionalIdToken_ from _idToken.additionalInfo.type_ = \"PaymentRecognition\". */
    @JsonProperty("paymentRecognition")
    private String paymentRecognition;


    @JsonProperty("customData")
    private CustomData customData;

}
