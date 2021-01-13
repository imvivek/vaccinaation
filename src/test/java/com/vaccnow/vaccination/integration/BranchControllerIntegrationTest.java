package com.vaccnow.vaccination.integration;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.vaccnow.vaccination.VaccinationApplication;

@SpringBootTest(classes = VaccinationApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class BranchControllerIntegrationTest {


}
