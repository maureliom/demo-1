package com.example.demo.model.ocpp.schema.notify_derstart_stop_request;

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
@Table(name = "notify_derstart_stop_request")
public class NotifyDERStartStopRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Size(max = 36)
    /** Id of the started or stopped DER control. Corresponds to the _controlId_ of the SetDERControlRequest. */
    @Column(name = "control_id")
    private String controlId;


    /** True if DER control has started. False if it has ended. */
    @Column(name = "started")
    private Boolean started;


    /** Time of start or end of event. */
    @Column(name = "timestamp")
    private String timestamp;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 24)
    /** List of controlIds that are superseded as a result of this control starting. */
    @Column(name = "superseded_ids")
    private List<String> supersededIds;

    @ElementCollection
    private List<String> supersededIds = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
