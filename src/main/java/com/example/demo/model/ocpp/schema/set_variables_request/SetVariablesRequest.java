package com.example.demo.model.ocpp.schema.set_variables_request;

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
@Table(name = "set_variables_request")
public class SetVariablesRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @ElementCollection
    @Size(min = 1)
    @Column(name = "set_variable_data")
    private List<SetVariableData> setVariableData;

    @ElementCollection
    private List<SetVariableData> setVariableData = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
