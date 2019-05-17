package com.sgic.hrm.employee.controller;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClientException;
import com.sgic.hrm.employee.HrmEmployeeApplicationTests;

public class RequestExperienceLetterControllerTest extends HrmEmployeeApplicationTests {

  @Autowired
  private JdbcTemplate jdbcTemplate;
  
//  @Autowired
//  private RequestExperienceLetterService requestExperienceLetter;

  @Before
  public void initializeData() {
    String newUser = "INSERT INTO employee.user (id, full_name) VALUES (1, 'natsu')";
    String requestExperienceLetterData = "INSERT INTO employee.request_experience_letter "
        + "(id, competency, created_at, no_of_copy, reason, status, user_id) "
        + "VALUES (1,'magic', '2018-11-22', 2, 'just for fun', 'rejected', 1)";
    jdbcTemplate.execute(newUser);
    jdbcTemplate.execute(requestExperienceLetterData);
  }

  @Test
  public void getAllExperienceLetterRequest() throws IOException, RestClientException {
    ResponseEntity<String> response =
        testRestTemplate.exchange(HRM_SYSTEM_BASE_URL + "/requestexpletter", HttpMethod.GET,
            new HttpEntity<>(httpHeaders), String.class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(requestExperienceLetterConstants.REQUEST_EXPERIENCE_LETTER_STRING,
        response.getBody());
  }

//  @Test
  public void createStudentCourse() throws Exception {
//      RequestExperienceLetterDto mockRequestExperienceLetter = new RequestExperienceLetterDto();
//
//      mockRequestExperienceLetter.setId(1);
//      mockRequestExperienceLetter.setUserId(1);;
//      mockRequestExperienceLetter.setNoOfCopy(2);;
//      mockRequestExperienceLetter.setReason("test-reason");
//      mockRequestExperienceLetter.setCompetency("test-competency");
//      mockRequestExperienceLetter.setCreatedAt(ZonedDateTime.now());
//      mockRequestExperienceLetter.setStatus("test-status");
      
      // studentService.addCourse to respond back with mockCourse
//      Mockito.when(
//              requestExperienceLetter.addExperienceLetterRequest(
//                      Mockito.any())).thenReturn(mockRequestExperienceLetter);
//
//      // Send course as body to /students/Student1/courses
//      RequestBuilder requestBuilder = MockMvcRequestBuilders
//              .post("/students/Student1/courses")
//              .accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
//              .contentType(MediaType.APPLICATION_JSON);
//
//      MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//      MockHttpServletResponse response = result.getResponse();
//
//      assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//
//      assertEquals("http://localhost/students/Student1/courses/1",
//              response.getHeader(HttpHeaders.LOCATION));

  }

  @After
  public void dropAll() {
    String leaveType1 = "delete from experience_letter.request_experience_letter where id=1";
    jdbcTemplate.execute(leaveType1);
  }


  private final class requestExperienceLetterConstants {
    private requestExperienceLetterConstants() {}

    private static final String REQUEST_EXPERIENCE_LETTER_STRING =
        "[{\"id\":1,\"user\":{\"id\":1,\"userName\":\"natsu\"},\"noOfCopy\":2,\"reason\":\"just for fun\",\"competency\":\"magic\",\"createdAt\":\"2018-11-22\",\"status\":\"rejected\"}]";

  }

}
