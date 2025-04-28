package com.example.demo.dto.ocpp.schema.notify_monitoring_report_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class VariableMonitoring {


    @Min(0)
    /** Identifies the monitor. */
    @JsonProperty("id")
    private Integer id;

    @Min(0.0)

    /** Monitor only active when a transaction is ongoing on a component relevant to this transaction. */
    @JsonProperty("transaction")
    private Boolean transaction;


    /** Value for threshold or delta monitoring. For Periodic or PeriodicClockAligned this is the interval in seconds. */
    @JsonProperty("value")
    private Double value;


    @JsonProperty("type")
    private MonitorEnum type;


    @Min(0)
    /** The severity that will be assigned to an event that is triggered by this monitor. The severity range is 0-9, with 0 as the highest and 9 as the lowest severity level. The severity levels have the following meaning: + *0-Danger* + Indicates lives are potentially in danger. Urgent attention is needed and action should be taken immediately. + *1-Hardware Failure* + Indicates that the Charging Station is unable to continue regular operations due to Hardware issues. Action is required. + *2-System Failure* + Indicates that the Charging Station is unable to continue regular operations due to software or minor hardware issues. Action is required. + *3-Critical* + Indicates a critical error. Action is required. + *4-Error* + Indicates a non-urgent error. Action is required. + *5-Alert* + Indicates an alert event. Default severity for any type of monitoring event. + *6-Warning* + Indicates a warning event. Action may be required. + *7-Notice* + Indicates an unusual event. No immediate action is required. + *8-Informational* + Indicates a regular operational event. May be used for reporting, measuring throughput, etc. No action is required. + *9-Debug* + Indicates information useful to developers for debugging, not useful during operations. */
    @JsonProperty("severity")
    private Integer severity;

    @Min(0.0)

    @JsonProperty("eventNotificationType")
    private EventNotificationEnum eventNotificationType;


    @JsonProperty("customData")
    private CustomData customData;

}
