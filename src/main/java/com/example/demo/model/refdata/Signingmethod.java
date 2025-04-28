package com.example.demo.model.refdata;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "signingmethod")
@Data
@NoArgsConstructor
public class Signingmethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "signing_method", columnDefinition = "TEXT")
    private String Signingmethod;

    @Column(name = "algorithm", columnDefinition = "TEXT")
    private String Algorithm;

    @Column(name = "curve", columnDefinition = "TEXT")
    private String Curve;

    @Column(name = "key length", columnDefinition = "TEXT")
    private String KeyLength;

    @Column(name = "hash algorithm", columnDefinition = "TEXT")
    private String HashAlgorithm;

}
