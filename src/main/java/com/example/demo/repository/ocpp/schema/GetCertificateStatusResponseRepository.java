package com.example.demo.repository.ocpp.schema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetCertificateStatusResponseRepository extends JpaRepository<GetCertificateStatusResponse, Long> {
}
