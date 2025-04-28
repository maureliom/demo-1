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
public class FixedVarGet {


    @Column(name = "fixed_var")
    private FixedVar fixedVar;


    @Size(max = 36)
    /** Id of setting */
    @Column(name = "id")
    private String id;


    /** True if setting is a default control. */
    @Column(name = "is_default")
    private Boolean isDefault;


    /** True if this setting is superseded by a lower priority setting */
    @Column(name = "is_superseded")
    private Boolean isSuperseded;


    @Column(name = "custom_data")
    private CustomData customData;

}
