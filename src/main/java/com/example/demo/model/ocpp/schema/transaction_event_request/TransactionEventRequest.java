package com.example.demo.model.ocpp.schema.transaction_event_request;

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
@Table(name = "transaction_event_request")
public class TransactionEventRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "cost_details")
    private CostDetails costDetails;


    @Column(name = "event_type")
    private TransactionEventEnum eventType;


    @ElementCollection
    @Size(min = 1)
    @Column(name = "meter_value")
    private List<MeterValue> meterValue;

    @ElementCollection
    private List<MeterValue> meterValue = new ArrayList<>();


    /** The date and time at which this transaction event occurred. */
    @Column(name = "timestamp")
    private String timestamp;


    @Column(name = "trigger_reason")
    private TriggerReasonEnum triggerReason;


    @Min(0)
    /** Incremental sequence number, helps with determining if all messages of a transaction have been received. */
    @Column(name = "seq_no")
    private Integer seqNo;

    @Min(0.0)

    /** Indication that this transaction event happened when the Charging Station was offline. Default = false, meaning: the event occurred when the Charging Station was online. */
    @Column(name = "offline")
    private Boolean offline;


    @Min(0)
    @Max(3)
    /** If the Charging Station is able to report the number of phases used, then it SHALL provide it. When omitted the CSMS may be able to determine the number of phases used as follows: + 1: The numberPhases in the currently used ChargingSchedule. + 2: The number of phases provided via device management. */
    @Column(name = "number_of_phases_used")
    private Integer numberOfPhasesUsed;

    @Min(0.0)
    @Max(3.0)

    /** The maximum current of the connected cable in Ampere (A). */
    @Column(name = "cable_max_current")
    private Integer cableMaxCurrent;


    @Min(0)
    /** This contains the Id of the reservation that terminates as a result of this transaction. */
    @Column(name = "reservation_id")
    private Integer reservationId;

    @Min(0.0)

    @Column(name = "preconditioning_status")
    private PreconditioningStatusEnum preconditioningStatus;


    /** *(2.1)* True when EVSE electronics are in sleep mode for this transaction. Default value (when absent) is false. */
    @Column(name = "evse_sleep")
    private Boolean evseSleep;


    @Column(name = "transaction_info")
    private Transaction transactionInfo;


    @Column(name = "evse")
    private EVSE evse;


    @Column(name = "id_token")
    private IdToken idToken;


    @Column(name = "custom_data")
    private CustomData customData;

}
