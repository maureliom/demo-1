package com.example.demo.model.ocpp.schema.authorize_response;

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
@Table(name = "authorize_response")
public class AuthorizeResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "id_token_info")
    private IdTokenInfo idTokenInfo;


    @Column(name = "certificate_status")
    private AuthorizeCertificateStatusEnum certificateStatus;


    @ElementCollection
    @Size(min = 1)
    /** *(2.1)* List of allowed energy transfer modes the EV can choose from. If omitted this defaults to charging only. */
    @Column(name = "allowed_energy_transfer")
    private List<EnergyTransferModeEnum> allowedEnergyTransfer;

    @ElementCollection
    private List<EnergyTransferModeEnum> allowedEnergyTransfer = new ArrayList<>();


    @Column(name = "tariff")
    private Tariff tariff;


    @Column(name = "custom_data")
    private CustomData customData;

}
