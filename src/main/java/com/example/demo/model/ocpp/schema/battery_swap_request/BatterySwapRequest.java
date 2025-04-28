package com.example.demo.model.ocpp.schema.battery_swap_request;

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
@Table(name = "battery_swap_request")
public class BatterySwapRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @ElementCollection
    @Size(min = 1)
    @Column(name = "battery_data")
    private List<BatteryData> batteryData;

    @ElementCollection
    private List<BatteryData> batteryData = new ArrayList<>();


    @Column(name = "event_type")
    private BatterySwapEventEnum eventType;


    @Column(name = "id_token")
    private IdToken idToken;


    /** RequestId to correlate BatteryIn/Out events and optional RequestBatterySwapRequest. */
    @Column(name = "request_id")
    private Integer requestId;


    @Column(name = "custom_data")
    private CustomData customData;

}
