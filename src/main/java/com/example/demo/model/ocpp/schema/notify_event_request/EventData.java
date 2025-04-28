package com.example.demo.model.ocpp.schema.notify_event_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class EventData {


    @Min(0)
    /** Identifies the event. This field can be referred to as a cause by other events. */
    @Column(name = "event_id")
    private Integer eventId;

    @Min(0.0)

    /** Timestamp of the moment the report was generated. */
    @Column(name = "timestamp")
    private String timestamp;


    @Column(name = "trigger")
    private EventTriggerEnum trigger;


    @Min(0)
    /** Refers to the Id of an event that is considered to be the cause for this event. */
    @Column(name = "cause")
    private Integer cause;

    @Min(0.0)

    @Size(max = 2500)
    /** Actual value (_attributeType_ Actual) of the variable. The Configuration Variable &lt;&lt;configkey-reporting-value-size,ReportingValueSize&gt;&gt; can be used to limit GetVariableResult.attributeValue, VariableAttribute.value and EventData.actualValue. The max size of these values will always remain equal. */
    @Column(name = "actual_value")
    private String actualValue;


    @Size(max = 50)
    /** Technical (error) code as reported by component. */
    @Column(name = "tech_code")
    private String techCode;


    @Size(max = 500)
    /** Technical detail information as reported by component. */
    @Column(name = "tech_info")
    private String techInfo;


    /** _Cleared_ is set to true to report the clearing of a monitored situation, i.e. a 'return to normal'. */
    @Column(name = "cleared")
    private Boolean cleared;


    @Size(max = 36)
    /** If an event notification is linked to a specific transaction, this field can be used to specify its transactionId. */
    @Column(name = "transaction_id")
    private String transactionId;


    @Column(name = "component")
    private Component component;


    @Min(0)
    /** Identifies the VariableMonitoring which triggered the event. */
    @Column(name = "variable_monitoring_id")
    private Integer variableMonitoringId;

    @Min(0.0)

    @Column(name = "event_notification_type")
    private EventNotificationEnum eventNotificationType;


    @Column(name = "variable")
    private Variable variable;


    @Min(0)
    /** *(2.1)* Severity associated with the monitor in _variableMonitoringId_ or with the hardwired notification. */
    @Column(name = "severity")
    private Integer severity;

    @Min(0.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
