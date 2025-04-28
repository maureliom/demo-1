package com.example.demo.model.ocpp.schema.get_variables_request;

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
@Table(name = "get_variables_request")
public class GetVariablesRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @ElementCollection
    @Size(min = 1)
    @Column(name = "get_variable_data")
    private List<GetVariableData> getVariableData;

    @ElementCollection
    private List<GetVariableData> getVariableData = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
