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
@Entity
@Table(name = "open_periodic_event_stream_request")
public class OpenPeriodicEventStreamRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "constant_stream_data")
    private ConstantStreamData constantStreamData;


    @Column(name = "custom_data")
    private CustomData customData;

}
