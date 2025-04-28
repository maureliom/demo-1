package com.example.demo.model.refdata;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reason_codes")
@Data
@NoArgsConstructor
public class ReasonCodes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group", columnDefinition = "TEXT")
    private String Group;

    @Column(name = "reason code", columnDefinition = "TEXT")
    private String ReasonCode;

    @Column(name = "description", columnDefinition = "TEXT")
    private String Description;

    @Column(name = "typically used for", columnDefinition = "TEXT")
    private String TypicallyUsedFor;

}
