package com.example.demo.model.ocpp.schema.clear_variable_monitoring_response;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ClearMonitoringResult {


    @Column(name = "status")
    private ClearMonitoringStatusEnum status;


    @Min(0)
    /** Id of the monitor of which a clear was requested. */
    @Column(name = "id")
    private Integer id;

    @Min(0.0)

    @Column(name = "status_info")
    private StatusInfo statusInfo;


    @Column(name = "custom_data")
    private CustomData customData;

}
