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
public class ReactivePowerParams {


    /** Only for VoltVar curve: The nominal ac voltage (rms) adjustment to the voltage curve points for Volt-Var curves (percentage). */
    @Column(name = "v_ref")
    private Double vRef;


    /** Only for VoltVar: Enable/disable autonomous VRef adjustment */
    @Column(name = "autonomous_vref_enable")
    private Boolean autonomousVRefEnable;


    /** Only for VoltVar: Adjustment range for VRef time constant */
    @Column(name = "autonomous_vref_time_constant")
    private Double autonomousVRefTimeConstant;


    @Column(name = "custom_data")
    private CustomData customData;

}
