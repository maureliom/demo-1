package com.example.demo.dto.ocpp.schema.set_dercontrol_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class SetDERControlRequest {


    /** True if this is a default DER control */
    @JsonProperty("isDefault")
    private Boolean isDefault;


    @Size(max = 36)
    /** Unique id of this control, e.g. UUID */
    @JsonProperty("controlId")
    private String controlId;


    @JsonProperty("controlType")
    private DERControlEnum controlType;


    @JsonProperty("curve")
    private DERCurve curve;


    @JsonProperty("enterService")
    private EnterService enterService;


    @JsonProperty("fixedPFAbsorb")
    private FixedPF fixedPFAbsorb;


    @JsonProperty("fixedPFInject")
    private FixedPF fixedPFInject;


    @JsonProperty("fixedVar")
    private FixedVar fixedVar;


    @JsonProperty("freqDroop")
    private FreqDroop freqDroop;


    @JsonProperty("gradient")
    private Gradient gradient;


    @JsonProperty("limitMaxDischarge")
    private LimitMaxDischarge limitMaxDischarge;


    @JsonProperty("customData")
    private CustomData customData;

}
