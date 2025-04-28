package com.example.demo.dto.ocpp.schema.report_dercontrol_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ReportDERControlRequest {


    @ElementCollection
    @Size(min = 1)
    @Size(max = 24)
    @JsonProperty("curve")
    private List<DERCurveGet> curve;

    @JsonProperty("curve")
    private List<DERCurveGet> curve = new ArrayList<>();


    @ElementCollection
    @Size(min = 1)
    @Size(max = 24)
    @JsonProperty("enterService")
    private List<EnterServiceGet> enterService;

    @JsonProperty("enterService")
    private List<EnterServiceGet> enterService = new ArrayList<>();


    @ElementCollection
    @Size(min = 1)
    @Size(max = 24)
    @JsonProperty("fixedPFAbsorb")
    private List<FixedPFGet> fixedPFAbsorb;

    @JsonProperty("fixedPFAbsorb")
    private List<FixedPFGet> fixedPFAbsorb = new ArrayList<>();


    @ElementCollection
    @Size(min = 1)
    @Size(max = 24)
    @JsonProperty("fixedPFInject")
    private List<FixedPFGet> fixedPFInject;

    @JsonProperty("fixedPFInject")
    private List<FixedPFGet> fixedPFInject = new ArrayList<>();


    @ElementCollection
    @Size(min = 1)
    @Size(max = 24)
    @JsonProperty("fixedVar")
    private List<FixedVarGet> fixedVar;

    @JsonProperty("fixedVar")
    private List<FixedVarGet> fixedVar = new ArrayList<>();


    @ElementCollection
    @Size(min = 1)
    @Size(max = 24)
    @JsonProperty("freqDroop")
    private List<FreqDroopGet> freqDroop;

    @JsonProperty("freqDroop")
    private List<FreqDroopGet> freqDroop = new ArrayList<>();


    @ElementCollection
    @Size(min = 1)
    @Size(max = 24)
    @JsonProperty("gradient")
    private List<GradientGet> gradient;

    @JsonProperty("gradient")
    private List<GradientGet> gradient = new ArrayList<>();


    @ElementCollection
    @Size(min = 1)
    @Size(max = 24)
    @JsonProperty("limitMaxDischarge")
    private List<LimitMaxDischargeGet> limitMaxDischarge;

    @JsonProperty("limitMaxDischarge")
    private List<LimitMaxDischargeGet> limitMaxDischarge = new ArrayList<>();


    /** RequestId from GetDERControlRequest. */
    @JsonProperty("requestId")
    private Integer requestId;


    /** To Be Continued. Default value when omitted: false. + False indicates that there are no further messages as part of this report. */
    @JsonProperty("tbc")
    private Boolean tbc;


    @JsonProperty("customData")
    private CustomData customData;

}
