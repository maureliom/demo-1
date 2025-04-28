package com.example.demo.model.ocpp.schema.set_variables_response;

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
@Table(name = "set_variables_response")
public class SetVariablesResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @ElementCollection
    @Size(min = 1)
    @Column(name = "set_variable_result")
    private List<SetVariableResult> setVariableResult;

    @ElementCollection
    private List<SetVariableResult> setVariableResult = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
