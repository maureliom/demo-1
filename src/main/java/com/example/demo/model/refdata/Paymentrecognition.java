package com.example.demo.model.refdata;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "paymentrecognition")
@Data
@NoArgsConstructor
public class Paymentrecognition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payment_recognition", columnDefinition = "TEXT")
    private String Paymentrecognition;

    @Column(name = "description", columnDefinition = "TEXT")
    private String Description;

}
