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
@Entity
@Table(name = "set_variable_monitoring_response")
public class SetVariableMonitoringResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @ElementCollection
    @Size(min = 1)
    @Column(name = "set_monitoring_result")
    private List<SetMonitoringResult> setMonitoringResult;

    @ElementCollection
    private List<SetMonitoringResult> setMonitoringResult = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
