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
@Entity
@Table(name = "report_dercontrol_request")
public class ReportDERControlRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 24)
    @Column(name = "curve")
    private List<DERCurveGet> curve;

    @ElementCollection
    private List<DERCurveGet> curve = new ArrayList<>();


    @ElementCollection
    @Size(min = 1)
    @Size(max = 24)
    @Column(name = "enter_service")
    private List<EnterServiceGet> enterService;

    @ElementCollection
    private List<EnterServiceGet> enterService = new ArrayList<>();


    @ElementCollection
    @Size(min = 1)
    @Size(max = 24)
    @Column(name = "fixed_pfabsorb")
    private List<FixedPFGet> fixedPFAbsorb;

    @ElementCollection
    private List<FixedPFGet> fixedPFAbsorb = new ArrayList<>();


    @ElementCollection
    @Size(min = 1)
    @Size(max = 24)
    @Column(name = "fixed_pfinject")
    private List<FixedPFGet> fixedPFInject;

    @ElementCollection
    private List<FixedPFGet> fixedPFInject = new ArrayList<>();


    @ElementCollection
    @Size(min = 1)
    @Size(max = 24)
    @Column(name = "fixed_var")
    private List<FixedVarGet> fixedVar;

    @ElementCollection
    private List<FixedVarGet> fixedVar = new ArrayList<>();


    @ElementCollection
    @Size(min = 1)
    @Size(max = 24)
    @Column(name = "freq_droop")
    private List<FreqDroopGet> freqDroop;

    @ElementCollection
    private List<FreqDroopGet> freqDroop = new ArrayList<>();


    @ElementCollection
    @Size(min = 1)
    @Size(max = 24)
    @Column(name = "gradient")
    private List<GradientGet> gradient;

    @ElementCollection
    private List<GradientGet> gradient = new ArrayList<>();


    @ElementCollection
    @Size(min = 1)
    @Size(max = 24)
    @Column(name = "limit_max_discharge")
    private List<LimitMaxDischargeGet> limitMaxDischarge;

    @ElementCollection
    private List<LimitMaxDischargeGet> limitMaxDischarge = new ArrayList<>();


    /** RequestId from GetDERControlRequest. */
    @Column(name = "request_id")
    private Integer requestId;


    /** To Be Continued. Default value when omitted: false. + False indicates that there are no further messages as part of this report. */
    @Column(name = "tbc")
    private Boolean tbc;


    @Column(name = "custom_data")
    private CustomData customData;

}
