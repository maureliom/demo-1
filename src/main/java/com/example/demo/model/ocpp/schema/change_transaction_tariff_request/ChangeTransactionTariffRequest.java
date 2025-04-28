package com.example.demo.model.ocpp.schema.change_transaction_tariff_request;

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
@Table(name = "change_transaction_tariff_request")
public class ChangeTransactionTariffRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "tariff")
    private Tariff tariff;


    @Size(max = 36)
    /** Transaction id for new tariff. */
    @Column(name = "transaction_id")
    private String transactionId;


    @Column(name = "custom_data")
    private CustomData customData;

}
