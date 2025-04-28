package com.example.demo.dto.ocpp.schema.set_charging_profile_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ChargingProfile {


    /** Id of ChargingProfile. Unique within charging station. Id can have a negative value. This is useful to distinguish charging profiles from an external actor (external constraints) from charging profiles received from CSMS. */
    @JsonProperty("id")
    private Integer id;


    @Min(0)
    /** Value determining level in hierarchy stack of profiles. Higher values have precedence over lower values. Lowest level is 0. */
    @JsonProperty("stackLevel")
    private Integer stackLevel;

    @Min(0.0)

    @JsonProperty("chargingProfilePurpose")
    private ChargingProfilePurposeEnum chargingProfilePurpose;


    @JsonProperty("chargingProfileKind")
    private ChargingProfileKindEnum chargingProfileKind;


    @JsonProperty("recurrencyKind")
    private RecurrencyKindEnum recurrencyKind;


    /** Point in time at which the profile starts to be valid. If absent, the profile is valid as soon as it is received by the Charging Station. */
    @JsonProperty("validFrom")
    private String validFrom;


    /** Point in time at which the profile stops to be valid. If absent, the profile is valid until it is replaced by another profile. */
    @JsonProperty("validTo")
    private String validTo;


    @Size(max = 36)
    /** SHALL only be included if ChargingProfilePurpose is set to TxProfile in a SetChargingProfileRequest. The transactionId is used to match the profile to a specific transaction. */
    @JsonProperty("transactionId")
    private String transactionId;


    /** *(2.1)* Period in seconds that this charging profile remains valid after the Charging Station has gone offline. After this period the charging profile becomes invalid for as long as it is offline and the Charging Station reverts back to a valid profile with a lower stack level. If _invalidAfterOfflineDuration_ is true, then this charging profile will become permanently invalid. A value of 0 means that the charging profile is immediately invalid while offline. When the field is absent, then no timeout applies and the charging profile remains valid when offline. */
    @JsonProperty("maxOfflineDuration")
    private Integer maxOfflineDuration;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 3)
    @JsonProperty("chargingSchedule")
    private List<ChargingSchedule> chargingSchedule;

    @JsonProperty("chargingSchedule")
    private List<ChargingSchedule> chargingSchedule = new ArrayList<>();


    /** *(2.1)* When set to true this charging profile will not be valid anymore after being offline for more than _maxOfflineDuration_. + When absent defaults to false. */
    @JsonProperty("invalidAfterOfflineDuration")
    private Boolean invalidAfterOfflineDuration;


    /** *(2.1)* Interval in seconds after receipt of last update, when to request a profile update by sending a PullDynamicScheduleUpdateRequest message. A value of 0 or no value means that no update interval applies. + Only relevant in a dynamic charging profile. */
    @JsonProperty("dynUpdateInterval")
    private Integer dynUpdateInterval;


    /** *(2.1)* Time at which limits or setpoints in this charging profile were last updated by a PullDynamicScheduleUpdateRequest or UpdateDynamicScheduleRequest or by an external actor. + Only relevant in a dynamic charging profile. */
    @JsonProperty("dynUpdateTime")
    private String dynUpdateTime;


    @Size(max = 256)
    /** *(2.1)* ISO 15118-20 signature for all price schedules in _chargingSchedules_. + Note: for 256-bit elliptic curves (like secp256k1) the ECDSA signature is 512 bits (64 bytes) and for 521-bit curves (like secp521r1) the signature is 1042 bits. This equals 131 bytes, which can be encoded as base64 in 176 bytes. */
    @JsonProperty("priceScheduleSignature")
    private String priceScheduleSignature;


    @JsonProperty("customData")
    private CustomData customData;

}
