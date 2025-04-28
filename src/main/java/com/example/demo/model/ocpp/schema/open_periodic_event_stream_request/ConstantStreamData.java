package com.example.demo.model.ocpp.schema.open_periodic_event_stream_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ConstantStreamData {


    @Min(0)
    /** Uniquely identifies the stream */
    @Column(name = "id")
    private Integer id;

    @Min(0.0)

    @Column(name = "params")
    private PeriodicEventStreamParams params;


    @Min(0)
    /** Id of monitor used to report his event. It can be a preconfigured or hardwired monitor. */
    @Column(name = "variable_monitoring_id")
    private Integer variableMonitoringId;

    @Min(0.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
