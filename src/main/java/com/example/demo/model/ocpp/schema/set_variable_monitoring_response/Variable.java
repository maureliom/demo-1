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
public class Variable {


    @Size(max = 50)
    /** Name of the variable. Name should be taken from the list of standardized variable names whenever possible. Case Insensitive. strongly advised to use Camel Case. */
    @Column(name = "name")
    private String name;


    @Size(max = 50)
    /** Name of instance in case the variable exists as multiple instances. Case Insensitive. strongly advised to use Camel Case. */
    @Column(name = "instance")
    private String instance;


    @Column(name = "custom_data")
    private CustomData customData;

}
