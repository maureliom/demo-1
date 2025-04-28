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
public class LimitMaxDischargeGet {


    @Size(max = 36)
    /** Id of setting */
    @Column(name = "id")
    private String id;


    /** True if setting is a default control. */
    @Column(name = "is_default")
    private Boolean isDefault;


    /** True if this setting is superseded by a higher priority setting (i.e. lower value of _priority_) */
    @Column(name = "is_superseded")
    private Boolean isSuperseded;


    @Column(name = "limit_max_discharge")
    private LimitMaxDischarge limitMaxDischarge;


    @Column(name = "custom_data")
    private CustomData customData;

}
