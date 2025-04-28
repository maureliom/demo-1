package com.example.demo.model.ocpp.schema.request_start_transaction_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ChargingProfile {


    /** Id of ChargingProfile. Unique within charging station. Id can have a negative value. This is useful to distinguish charging profiles from an external actor (external constraints) from charging profiles received from CSMS. */
    @Column(name = "id")
    private Integer id;


    @Min(0)
    /** Value determining level in hierarchy stack of profiles. Higher values have precedence over lower values. Lowest level is 0. */
    @Column(name = "stack_level")
    private Integer stackLevel;

    @Min(0.0)

    @Column(name = "charging_profile_purpose")
    private ChargingProfilePurposeEnum chargingProfilePurpose;


    @Column(name = "charging_profile_kind")
    private ChargingProfileKindEnum chargingProfileKind;


    @Column(name = "recurrency_kind")
    private RecurrencyKindEnum recurrencyKind;


    /** Point in time at which the profile starts to be valid. If absent, the profile is valid as soon as it is received by the Charging Station. */
    @Column(name = "valid_from")
    private String validFrom;


    /** Point in time at which the profile stops to be valid. If absent, the profile is valid until it is replaced by another profile. */
    @Column(name = "valid_to")
    private String validTo;


    @Size(max = 36)
    /** SHALL only be included if ChargingProfilePurpose is set to TxProfile in a SetChargingProfileRequest. The transactionId is used to match the profile to a specific transaction. */
    @Column(name = "transaction_id")
    private String transactionId;


    /** *(2.1)* Period in seconds that this charging profile remains valid after the Charging Station has gone offline. After this period the charging profile becomes invalid for as long as it is offline and the Charging Station reverts back to a valid profile with a lower stack level. If _invalidAfterOfflineDuration_ is true, then this charging profile will become permanently invalid. A value of 0 means that the charging profile is immediately invalid while offline. When the field is absent, then no timeout applies and the charging profile remains valid when offline. */
    @Column(name = "max_offline_duration")
    private Integer maxOfflineDuration;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 3)
    @Column(name = "charging_schedule")
    private List<ChargingSchedule> chargingSchedule;

    @ElementCollection
    private List<ChargingSchedule> chargingSchedule = new ArrayList<>();


    /** *(2.1)* When set to true this charging profile will not be valid anymore after being offline for more than _maxOfflineDuration_. + When absent defaults to false. */
    @Column(name = "invalid_after_offline_duration")
    private Boolean invalidAfterOfflineDuration;


    /** *(2.1)* Interval in seconds after receipt of last update, when to request a profile update by sending a PullDynamicScheduleUpdateRequest message. A value of 0 or no value means that no update interval applies. + Only relevant in a dynamic charging profile. */
    @Column(name = "dyn_update_interval")
    private Integer dynUpdateInterval;


    /** *(2.1)* Time at which limits or setpoints in this charging profile were last updated by a PullDynamicScheduleUpdateRequest or UpdateDynamicScheduleRequest or by an external actor. + Only relevant in a dynamic charging profile. */
    @Column(name = "dyn_update_time")
    private String dynUpdateTime;


    @Size(max = 256)
    /** *(2.1)* ISO 15118-20 signature for all price schedules in _chargingSchedules_. + Note: for 256-bit elliptic curves (like secp256k1) the ECDSA signature is 512 bits (64 bytes) and for 521-bit curves (like secp521r1) the signature is 1042 bits. This equals 131 bytes, which can be encoded as base64 in 176 bytes. */
    @Column(name = "price_schedule_signature")
    private String priceScheduleSignature;


    @Column(name = "custom_data")
    private CustomData customData;

}
