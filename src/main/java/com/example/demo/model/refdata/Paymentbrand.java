package com.example.demo.model.refdata;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "paymentbrand")
@Data
@NoArgsConstructor
public class Paymentbrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payment_brand", columnDefinition = "TEXT")
    private String Paymentbrand;

    @Column(name = "description", columnDefinition = "TEXT")
    private String Description;

}
