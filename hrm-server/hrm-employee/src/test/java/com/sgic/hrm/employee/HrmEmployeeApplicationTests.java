package com.sgic.hrm.employee;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
public class HrmEmployeeApplicationTests {

  @Autowired
  protected TestRestTemplate testRestTemplate;
  protected HttpHeaders httpHeaders = new HttpHeaders();

  @Value("http://localhost:8888/hrm_system")
  protected String HRM_SYSTEM_BASE_URL;
}
	

