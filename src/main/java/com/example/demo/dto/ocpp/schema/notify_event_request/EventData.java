package com.example.demo.dto.ocpp.schema.notify_event_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class EventData {


    @Min(0)
    /** Identifies the event. This field can be referred to as a cause by other events. */
    @JsonProperty("eventId")
    private Integer eventId;

    @Min(0.0)

    /** Timestamp of the moment the report was generated. */
    @JsonProperty("timestamp")
    private String timestamp;


    @JsonProperty("trigger")
    private EventTriggerEnum trigger;


    @Min(0)
    /** Refers to the Id of an event that is considered to be the cause for this event. */
    @JsonProperty("cause")
    private Integer cause;

    @Min(0.0)

    @Size(max = 2500)
    /** Actual value (_attributeType_ Actual) of the variable. The Configuration Variable &lt;&lt;configkey-reporting-value-size,ReportingValueSize&gt;&gt; can be used to limit GetVariableResult.attributeValue, VariableAttribute.value and EventData.actualValue. The max size of these values will always remain equal. */
    @JsonProperty("actualValue")
    private String actualValue;


    @Size(max = 50)
    /** Technical (error) code as reported by component. */
    @JsonProperty("techCode")
    private String techCode;


    @Size(max = 500)
    /** Technical detail information as reported by component. */
    @JsonProperty("techInfo")
    private String techInfo;


    /** _Cleared_ is set to true to report the clearing of a monitored situation, i.e. a 'return to normal'. */
    @JsonProperty("cleared")
    private Boolean cleared;


    @Size(max = 36)
    /** If an event notification is linked to a specific transaction, this field can be used to specify its transactionId. */
    @JsonProperty("transactionId")
    private String transactionId;


    @JsonProperty("component")
    private Component component;


    @Min(0)
    /** Identifies the VariableMonitoring which triggered the event. */
    @JsonProperty("variableMonitoringId")
    private Integer variableMonitoringId;

    @Min(0.0)

    @JsonProperty("eventNotificationType")
    private EventNotificationEnum eventNotificationType;


    @JsonProperty("variable")
    private Variable variable;


    @Min(0)
    /** *(2.1)* Severity associated with the monitor in _variableMonitoringId_ or with the hardwired notification. */
    @JsonProperty("severity")
    private Integer severity;

    @Min(0.0)

    @JsonProperty("customData")
    private CustomData customData;

}
