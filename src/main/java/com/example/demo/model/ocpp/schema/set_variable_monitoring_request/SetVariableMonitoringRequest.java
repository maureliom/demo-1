package com.example.demo.model.ocpp.schema.set_variable_monitoring_request;

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
@Table(name = "set_variable_monitoring_request")
public class SetVariableMonitoringRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @ElementCollection
    @Size(min = 1)
    @Column(name = "set_monitoring_data")
    private List<SetMonitoringData> setMonitoringData;

    @ElementCollection
    private List<SetMonitoringData> setMonitoringData = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
