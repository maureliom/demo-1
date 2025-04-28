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
public class LimitMaxDischarge {


    @Min(0)
    /** Priority of setting (0=highest) */
    @Column(name = "priority")
    private Integer priority;

    @Min(0.0)

    /** Only for PowerMonitoring. + The value specifies a percentage (0 to 100) of the rated maximum discharge power of EV. The PowerMonitoring curve becomes active when power exceeds this percentage. */
    @Column(name = "pct_max_discharge_power")
    private Double pctMaxDischargePower;


    @Column(name = "power_monitoring_must_trip")
    private DERCurve powerMonitoringMustTrip;


    /** Time when this setting becomes active */
    @Column(name = "start_time")
    private String startTime;


    /** Duration in seconds that this setting is active */
    @Column(name = "duration")
    private Double duration;


    @Column(name = "custom_data")
    private CustomData customData;

}
