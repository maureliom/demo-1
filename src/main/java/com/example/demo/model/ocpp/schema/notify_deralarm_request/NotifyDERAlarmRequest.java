package com.example.demo.model.ocpp.schema.notify_deralarm_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "notify_deralarm_request")
public class NotifyDERAlarmRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "control_type")
    private DERControlEnum controlType;


    @Column(name = "grid_event_fault")
    private GridEventFaultEnum gridEventFault;


    /** True when error condition has ended. Absent or false when alarm has started. */
    @Column(name = "alarm_ended")
    private Boolean alarmEnded;


    /** Time of start or end of alarm. */
    @Column(name = "timestamp")
    private String timestamp;


    @Size(max = 200)
    /** Optional info provided by EV. */
    @Column(name = "extra_info")
    private String extraInfo;


    @Column(name = "custom_data")
    private CustomData customData;

}
