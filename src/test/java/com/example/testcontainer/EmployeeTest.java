package com.example.testcontainer;

import com.example.testcontainer.models.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.net.URI;
import java.net.URISyntaxException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://programmerfriend.com/testcontainers-springboot-real-database --> docker preparation
 *
 * https://medium.com/javarevisited/spring-boot-testing-testcontainers-and-flyway-df4a71376db4
 * https://howtodoinjava.com/spring-boot2/testing/spring-boot-junit-resttemplate/
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@ActiveProfiles("integration")
class EmployeeTest {

    @LocalServerPort
    int randomServerPort;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testSaveEmployee() throws URISyntaxException {

        final String baseUrl = "http://localhost:" + randomServerPort + "/employee";
        URI uri = new URI(baseUrl);

        Employee requestBody = new Employee();
        requestBody.setName("Guru");
        requestBody.setAddress("Subang");

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Employee> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Employee> result = restTemplate.exchange(uri.toString(), HttpMethod.POST, requestEntity, Employee.class);
        assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(result.getBody().getAddress(), equalTo("Subang"));
    }

    @Test
    public void testGetEmployee() throws URISyntaxException {

        final String baseUrl = "http://localhost:" + randomServerPort + "/employee?name=Guru";
        URI uri = new URI(baseUrl);

        ResponseEntity<Employee> result = restTemplate.getForEntity(uri, Employee.class);
        assertThat(result.getBody().getAddress(), equalTo("Subang"));
    }
}