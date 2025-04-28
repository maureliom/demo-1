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
public class DERCurvePoints {


    /** The data value of the X-axis (independent) variable, depending on the curve type. */
    @Column(name = "x")
    private Double x;


    /** The data value of the Y-axis (dependent) variable, depending on the &lt;&lt;cmn_derunitenumtype&gt;&gt; of the curve. If _y_ is power factor, then a positive value means DER is absorbing reactive power (under-excited), a negative value when DER is injecting reactive power (over-excited). */
    @Column(name = "y")
    private Double y;


    @Column(name = "custom_data")
    private CustomData customData;

}
