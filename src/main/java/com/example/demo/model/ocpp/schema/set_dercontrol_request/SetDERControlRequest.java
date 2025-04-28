package com.example.demo.model.ocpp.schema.set_dercontrol_request;

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
@Table(name = "set_dercontrol_request")
public class SetDERControlRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    /** True if this is a default DER control */
    @Column(name = "is_default")
    private Boolean isDefault;


    @Size(max = 36)
    /** Unique id of this control, e.g. UUID */
    @Column(name = "control_id")
    private String controlId;


    @Column(name = "control_type")
    private DERControlEnum controlType;


    @Column(name = "curve")
    private DERCurve curve;


    @Column(name = "enter_service")
    private EnterService enterService;


    @Column(name = "fixed_pfabsorb")
    private FixedPF fixedPFAbsorb;


    @Column(name = "fixed_pfinject")
    private FixedPF fixedPFInject;


    @Column(name = "fixed_var")
    private FixedVar fixedVar;


    @Column(name = "freq_droop")
    private FreqDroop freqDroop;


    @Column(name = "gradient")
    private Gradient gradient;


    @Column(name = "limit_max_discharge")
    private LimitMaxDischarge limitMaxDischarge;


    @Column(name = "custom_data")
    private CustomData customData;

}
