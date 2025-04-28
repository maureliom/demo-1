package com.example.demo.model.ocpp.schema.set_variable_monitoring_response;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class SetMonitoringResult {


    @Min(0)
    /** Id given to the VariableMonitor by the Charging Station. The Id is only returned when status is accepted. Installed VariableMonitors should have unique id's but the id's of removed Installed monitors should have unique id's but the id's of removed monitors MAY be reused. */
    @Column(name = "id")
    private Integer id;

    @Min(0.0)

    @Column(name = "status_info")
    private StatusInfo statusInfo;


    @Column(name = "status")
    private SetMonitoringStatusEnum status;


    @Column(name = "type")
    private MonitorEnum type;


    @Column(name = "component")
    private Component component;


    @Column(name = "variable")
    private Variable variable;


    @Min(0)
    /** The severity that will be assigned to an event that is triggered by this monitor. The severity range is 0-9, with 0 as the highest and 9 as the lowest severity level. The severity levels have the following meaning: + *0-Danger* + Indicates lives are potentially in danger. Urgent attention is needed and action should be taken immediately. + *1-Hardware Failure* + Indicates that the Charging Station is unable to continue regular operations due to Hardware issues. Action is required. + *2-System Failure* + Indicates that the Charging Station is unable to continue regular operations due to software or minor hardware issues. Action is required. + *3-Critical* + Indicates a critical error. Action is required. + *4-Error* + Indicates a non-urgent error. Action is required. + *5-Alert* + Indicates an alert event. Default severity for any type of monitoring event. + *6-Warning* + Indicates a warning event. Action may be required. + *7-Notice* + Indicates an unusual event. No immediate action is required. + *8-Informational* + Indicates a regular operational event. May be used for reporting, measuring throughput, etc. No action is required. + *9-Debug* + Indicates information useful to developers for debugging, not useful during operations. */
    @Column(name = "severity")
    private Integer severity;

    @Min(0.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
