package com.example.demo.tests;

import com.example.demo.security.JwtTokenProvider;
import lombok.extern.slf4j.Slf4j;
//import com.example.demo.model.refdata.RefData;
//import com.example.demo.repository.refdata.RefDataRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootTest
public class RefDataT {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

//    @Autowired
//    private RefDataRepository refdataRepository;

    @Test
    @Rollback(false)
    void setupUserAndToken() {
//        refdataRepository.deleteAll();
        
//        RefData refdata = new RefData();
//        refdata.setEmail("email@refdata");
//        refdata.setPassword("senha refdata");
//        refdata.setUsername("user refdata");
        
//        refdataRepository.save(refdata); 
        
    }
}
