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
public class PeriodicEventStreamParams {


    @Min(0)
    /** Time in seconds after which stream data is sent. */
    @Column(name = "interval")
    private Integer interval;

    @Min(0.0)

    @Min(0)
    /** Number of items to be sent together in stream. */
    @Column(name = "values")
    private Integer values;

    @Min(0.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
