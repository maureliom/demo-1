package com.example.demo.model.ocpp.schema.notify_periodic_event_stream;

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
@Table(name = "notify_periodic_event_stream")
public class NotifyPeriodicEventStream {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @ElementCollection
    @Size(min = 1)
    @Column(name = "data")
    private List<StreamDataElement> data;

    @ElementCollection
    private List<StreamDataElement> data = new ArrayList<>();


    @Min(0)
    /** Id of stream. */
    @Column(name = "id")
    private Integer id;

    @Min(0.0)

    @Min(0)
    /** Number of data elements still pending to be sent. */
    @Column(name = "pending")
    private Integer pending;

    @Min(0.0)

    /** Base timestamp to add to time offset of values. */
    @Column(name = "basetime")
    private String basetime;


    @Column(name = "custom_data")
    private CustomData customData;

}
