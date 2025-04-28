package com.example.demo.model.ocpp.schema.get_report_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ComponentVariable {


    @Column(name = "component")
    private Component component;


    @Column(name = "variable")
    private Variable variable;


    @Column(name = "custom_data")
    private CustomData customData;

}
