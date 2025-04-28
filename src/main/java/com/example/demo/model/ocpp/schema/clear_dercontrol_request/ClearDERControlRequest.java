package com.example.demo.model.ocpp.schema.clear_dercontrol_request;

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
@Table(name = "clear_dercontrol_request")
public class ClearDERControlRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    /** True: clearing default DER controls. False: clearing scheduled controls. */
    @Column(name = "is_default")
    private Boolean isDefault;


    @Column(name = "control_type")
    private DERControlEnum controlType;


    @Size(max = 36)
    /** Id of control setting to clear. When omitted all settings for _controlType_ are cleared. */
    @Column(name = "control_id")
    private String controlId;


    @Column(name = "custom_data")
    private CustomData customData;

}
