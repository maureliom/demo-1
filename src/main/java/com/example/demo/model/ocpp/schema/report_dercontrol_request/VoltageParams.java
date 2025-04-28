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
public class VoltageParams {


    /** EN 50549-1 chapter 4.9.3.4 Voltage threshold for the 10 min time window mean value monitoring. The 10 min mean is recalculated up to every 3 s. If the present voltage is above this threshold for more than the time defined by _hv10MinMeanValue_, the EV must trip. This value is mandatory if _hv10MinMeanTripDelay_ is set. */
    @Column(name = "hv10min_mean_value")
    private Double hv10MinMeanValue;


    /** Time for which the voltage is allowed to stay above the 10 min mean value. After this time, the EV must trip. This value is mandatory if OverVoltageMeanValue10min is set. */
    @Column(name = "hv10min_mean_trip_delay")
    private Double hv10MinMeanTripDelay;


    @Column(name = "power_during_cessation")
    private PowerDuringCessationEnum powerDuringCessation;


    @Column(name = "custom_data")
    private CustomData customData;

}
