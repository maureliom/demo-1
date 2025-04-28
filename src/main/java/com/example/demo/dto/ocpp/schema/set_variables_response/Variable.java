package com.example.demo.dto.ocpp.schema.set_variables_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class Variable {


    @Size(max = 50)
    /** Name of the variable. Name should be taken from the list of standardized variable names whenever possible. Case Insensitive. strongly advised to use Camel Case. */
    @JsonProperty("name")
    private String name;


    @Size(max = 50)
    /** Name of instance in case the variable exists as multiple instances. Case Insensitive. strongly advised to use Camel Case. */
    @JsonProperty("instance")
    private String instance;


    @JsonProperty("customData")
    private CustomData customData;

}
