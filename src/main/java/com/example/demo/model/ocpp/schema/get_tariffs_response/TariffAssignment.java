package com.example.demo.model.ocpp.schema.get_tariffs_response;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class TariffAssignment {


    @Size(max = 60)
    /** Tariff id. */
    @Column(name = "tariff_id")
    private String tariffId;


    @Column(name = "tariff_kind")
    private TariffKindEnum tariffKind;


    /** Date/time when this tariff become active. */
    @Column(name = "valid_from")
    private String validFrom;


    @ElementCollection
    @Size(min = 1)
    @Column(name = "evse_ids")
    private List<Integer> evseIds;

    @ElementCollection
    private List<Integer> evseIds = new ArrayList<>();


    @ElementCollection
    @Size(min = 1)
    /** IdTokens related to tariff */
    @Column(name = "id_tokens")
    private List<String> idTokens;

    @ElementCollection
    private List<String> idTokens = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
