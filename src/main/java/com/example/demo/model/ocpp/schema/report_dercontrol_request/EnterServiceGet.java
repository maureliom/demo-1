package com.example.demo.model.ocpp.schema.report_dercontrol_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class EnterServiceGet {


    @Column(name = "enter_service")
    private EnterService enterService;


    @Size(max = 36)
    /** Id of setting */
    @Column(name = "id")
    private String id;


    @Column(name = "custom_data")
    private CustomData customData;

}
