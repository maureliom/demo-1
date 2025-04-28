package com.example.demo.model.ocpp.schema.clear_variable_monitoring_request;

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
@Table(name = "clear_variable_monitoring_request")
public class ClearVariableMonitoringRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @ElementCollection
    @Size(min = 1)
    /** List of the monitors to be cleared, identified by there Id. */
    @Column(name = "id")
    private List<Integer> id;

    @ElementCollection
    private List<Integer> id = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
