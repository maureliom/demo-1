package com.example.demo.model.ocpp.schema.close_periodic_event_stream_request;

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
@Table(name = "close_periodic_event_stream_request")
public class ClosePeriodicEventStreamRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Min(0)
    /** Id of stream to close. */
    @Column(name = "id")
    private Integer id;

    @Min(0.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
