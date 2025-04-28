package com.example.demo.model.refdata;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "security_events")
@Data
@NoArgsConstructor
public class SecurityEvents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "security event", columnDefinition = "TEXT")
    private String SecurityEvent;

    @Column(name = "description", columnDefinition = "TEXT")
    private String Description;

    @Column(name = "critical", columnDefinition = "TEXT")
    private String Critical;

}
