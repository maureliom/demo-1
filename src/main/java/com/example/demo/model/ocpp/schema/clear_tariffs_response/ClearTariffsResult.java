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
public class ClearTariffsResult {


    @Column(name = "status_info")
    private StatusInfo statusInfo;


    @Size(max = 60)
    /** Id of tariff for which _status_ is reported. If no tariffs were found, then this field is absent, and _status_ will be `NoTariff`. */
    @Column(name = "tariff_id")
    private String tariffId;


    @Column(name = "status")
    private TariffClearStatusEnum status;


    @Column(name = "custom_data")
    private CustomData customData;

}
