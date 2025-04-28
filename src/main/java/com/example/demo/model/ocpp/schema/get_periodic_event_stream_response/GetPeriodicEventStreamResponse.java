package com.example.demo.model.ocpp.schema.get_periodic_event_stream_response;

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
@Table(name = "get_periodic_event_stream_response")
public class GetPeriodicEventStreamResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @ElementCollection
    @Size(min = 1)
    @Column(name = "constant_stream_data")
    private List<ConstantStreamData> constantStreamData;

    @ElementCollection
    private List<ConstantStreamData> constantStreamData = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
