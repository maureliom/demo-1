package com.example.demo.model.ocpp.schema.clear_tariffs_response;

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
@Table(name = "clear_tariffs_response")
public class ClearTariffsResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @ElementCollection
    @Size(min = 1)
    @Column(name = "clear_tariffs_result")
    private List<ClearTariffsResult> clearTariffsResult;

    @ElementCollection
    private List<ClearTariffsResult> clearTariffsResult = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
