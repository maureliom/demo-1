package com.example.demo.model.ocpp.schema.clear_variable_monitoring_response;

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
@Table(name = "clear_variable_monitoring_response")
public class ClearVariableMonitoringResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @ElementCollection
    @Size(min = 1)
    @Column(name = "clear_monitoring_result")
    private List<ClearMonitoringResult> clearMonitoringResult;

    @ElementCollection
    private List<ClearMonitoringResult> clearMonitoringResult = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
