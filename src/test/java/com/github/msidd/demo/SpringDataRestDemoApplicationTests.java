package com.github.msidd.demo;

import com.github.msidd.demo.SpringDataRestDemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;


import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringDataRestDemoApplication.class)
@IntegrationTest({"server.port=0", "management.port=0"})
@WebAppConfiguration
@DirtiesContext
public class SpringDataRestDemoApplicationTests {
    @Value("${local.server.port}")
    private int port;

    //test that users end point is alive dont care if what it is returning
    @Test
    public void testUserEndPoint() {
        ResponseEntity<Map> entity = new TestRestTemplate().getForEntity(
                "http://localhost:" + this.port + "/users", Map.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());


    }
    //test that users end point is alive and returning 200
    @Test
    public void testDirEndPoint() {
        ResponseEntity entity = new TestRestTemplate().getForEntity(
                "http://localhost:" + this.port + "/directoryList", Object[].class);
        //dont care what it is returning
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    //test that authentication is working as expected
    @Test
    public void testAuthenticateSuccess() {
        ResponseEntity<Map> entity = new TestRestTemplate().postForEntity(
                "http://localhost:" + this.port + "/login", "{\"username\":\"msidd0\",\"password\":\"user0\"}", Map.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }




}
