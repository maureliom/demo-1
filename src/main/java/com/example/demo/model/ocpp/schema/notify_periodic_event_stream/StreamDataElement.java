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
public class StreamDataElement {


    /** Offset relative to _basetime_ of this message. _basetime_ + _t_ is timestamp of recorded value. */
    @Column(name = "t")
    private Double t;


    @Size(max = 2500)
    @Column(name = "v")
    private String v;


    @Column(name = "custom_data")
    private CustomData customData;

}
