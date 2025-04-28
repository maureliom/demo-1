package com.example.demo.dto.ocpp.schema.set_dercontrol_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class DERCurvePoints {


    /** The data value of the X-axis (independent) variable, depending on the curve type. */
    @JsonProperty("x")
    private Double x;


    /** The data value of the Y-axis (dependent) variable, depending on the &lt;&lt;cmn_derunitenumtype&gt;&gt; of the curve. If _y_ is power factor, then a positive value means DER is absorbing reactive power (under-excited), a negative value when DER is injecting reactive power (over-excited). */
    @JsonProperty("y")
    private Double y;


    @JsonProperty("customData")
    private CustomData customData;

}
