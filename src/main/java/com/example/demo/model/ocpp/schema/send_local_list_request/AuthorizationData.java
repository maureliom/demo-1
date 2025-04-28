package com.example.demo.model.ocpp.schema.send_local_list_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class AuthorizationData {


    @Column(name = "id_token")
    private IdToken idToken;


    @Column(name = "id_token_info")
    private IdTokenInfo idTokenInfo;


    @Column(name = "custom_data")
    private CustomData customData;

}
