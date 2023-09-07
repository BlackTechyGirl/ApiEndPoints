package com.myEndPoint;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiControllerIntegrationTest {

        @LocalServerPort
        private int port;

        private TestRestTemplate restTemplate = new TestRestTemplate();

        @Test
        public void testApiEndpoint() {
            String url = "http://localhost:" + port + "/api?name=Martha&track=backend";

            String response = restTemplate.getForObject(url, String.class);
        }

}
