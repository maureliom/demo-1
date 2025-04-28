package com.example.demo.model.ocpp.schema.notify_allowed_energy_transfer_request;

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
@Table(name = "notify_allowed_energy_transfer_request")
public class NotifyAllowedEnergyTransferRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Size(max = 36)
    /** The transaction for which the allowed energy transfer is allowed. */
    @Column(name = "transaction_id")
    private String transactionId;


    @ElementCollection
    @Size(min = 1)
    /** Modes of energy transfer that are accepted by CSMS. */
    @Column(name = "allowed_energy_transfer")
    private List<EnergyTransferModeEnum> allowedEnergyTransfer;

    @ElementCollection
    private List<EnergyTransferModeEnum> allowedEnergyTransfer = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
