package com.example.demo.dto.ocpp.schema.transaction_event_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class TransactionEventRequest {


    @JsonProperty("costDetails")
    private CostDetails costDetails;


    @JsonProperty("eventType")
    private TransactionEventEnum eventType;


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("meterValue")
    private List<MeterValue> meterValue;

    @JsonProperty("meterValue")
    private List<MeterValue> meterValue = new ArrayList<>();


    /** The date and time at which this transaction event occurred. */
    @JsonProperty("timestamp")
    private String timestamp;


    @JsonProperty("triggerReason")
    private TriggerReasonEnum triggerReason;


    @Min(0)
    /** Incremental sequence number, helps with determining if all messages of a transaction have been received. */
    @JsonProperty("seqNo")
    private Integer seqNo;

    @Min(0.0)

    /** Indication that this transaction event happened when the Charging Station was offline. Default = false, meaning: the event occurred when the Charging Station was online. */
    @JsonProperty("offline")
    private Boolean offline;


    @Min(0)
    @Max(3)
    /** If the Charging Station is able to report the number of phases used, then it SHALL provide it. When omitted the CSMS may be able to determine the number of phases used as follows: + 1: The numberPhases in the currently used ChargingSchedule. + 2: The number of phases provided via device management. */
    @JsonProperty("numberOfPhasesUsed")
    private Integer numberOfPhasesUsed;

    @Min(0.0)
    @Max(3.0)

    /** The maximum current of the connected cable in Ampere (A). */
    @JsonProperty("cableMaxCurrent")
    private Integer cableMaxCurrent;


    @Min(0)
    /** This contains the Id of the reservation that terminates as a result of this transaction. */
    @JsonProperty("reservationId")
    private Integer reservationId;

    @Min(0.0)

    @JsonProperty("preconditioningStatus")
    private PreconditioningStatusEnum preconditioningStatus;


    /** *(2.1)* True when EVSE electronics are in sleep mode for this transaction. Default value (when absent) is false. */
    @JsonProperty("evseSleep")
    private Boolean evseSleep;


    @JsonProperty("transactionInfo")
    private Transaction transactionInfo;


    @JsonProperty("evse")
    private EVSE evse;


    @JsonProperty("idToken")
    private IdToken idToken;


    @JsonProperty("customData")
    private CustomData customData;

}
