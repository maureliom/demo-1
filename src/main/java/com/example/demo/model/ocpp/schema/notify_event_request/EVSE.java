package com.example.demo.model.ocpp.schema.notify_event_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class EVSE {


    @Min(0)
    /** EVSE Identifier. This contains a number (&gt; 0) designating an EVSE of the Charging Station. */
    @Column(name = "id")
    private Integer id;

    @Min(0.0)

    @Min(0)
    /** An id to designate a specific connector (on an EVSE) by connector index number. */
    @Column(name = "connector_id")
    private Integer connectorId;

    @Min(0.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
