package com.example.demo.model.ocpp.schema.notify_monitoring_report_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class MonitoringData {


    @Column(name = "component")
    private Component component;


    @Column(name = "variable")
    private Variable variable;


    @ElementCollection
    @Size(min = 1)
    @Column(name = "variable_monitoring")
    private List<VariableMonitoring> variableMonitoring;

    @ElementCollection
    private List<VariableMonitoring> variableMonitoring = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
