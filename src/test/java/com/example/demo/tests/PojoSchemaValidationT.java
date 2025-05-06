package com.example.demo.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.JpaEntityProcessorService;
import com.example.demo.service.SchemaProcessorService;
//import com.example.demo.service.SchemaProcessorService;
@SpringBootTest
public class PojoSchemaValidationT {
	
	@Autowired
	SchemaProcessorService schemaProcessorService;
	@Autowired
	JpaEntityProcessorService jpaProcessorService;	
	
	
	@Test
	public void testSchemaPojoGeneration() {
		schemaProcessorService.run(); 
		jpaProcessorService.run();
	    // Manually inspect output or assert files exist if desired
	}
}
