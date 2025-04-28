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
public class SignedMeterValue {


    @Size(max = 32768)
    /** Base64 encoded, contains the signed data from the meter in the format specified in _encodingMethod_, which might contain more then just the meter value. It can contain information like timestamps, reference to a customer etc. */
    @Column(name = "signed_meter_data")
    private String signedMeterData;


    @Size(max = 50)
    /** *(2.1)* Method used to create the digital signature. Optional, if already included in _signedMeterData_. Standard values for this are defined in Appendix as SigningMethodEnumStringType. */
    @Column(name = "signing_method")
    private String signingMethod;


    @Size(max = 50)
    /** Format used by the energy meter to encode the meter data. For example: OCMF or EDL. */
    @Column(name = "encoding_method")
    private String encodingMethod;


    @Size(max = 2500)
    /** *(2.1)* Base64 encoded, sending depends on configuration variable _PublicKeyWithSignedMeterValue_. */
    @Column(name = "public_key")
    private String publicKey;


    @Column(name = "custom_data")
    private CustomData customData;

}
