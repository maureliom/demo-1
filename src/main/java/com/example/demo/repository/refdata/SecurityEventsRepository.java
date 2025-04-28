package com.example.demo.repository.refdata;

import com.example.demo.model.refdata.SecurityEvents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityEventsRepository extends JpaRepository<SecurityEvents, Long> {
}
