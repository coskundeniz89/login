package com.teammental.login.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.nio.charset.Charset;
import java.util.Base64;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

/**
 * Created by coskun on 05.08.2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = LoginController.class)
public class LoginControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @WithMockUser(username = "test", password = "123", roles = "USER")
  public void loginSuccess() throws Exception {

    String userName = "test";
    String password = "123";

    byte[] authenticationByte = (userName + ":" + password).getBytes(Charset.forName("UTF-8"));

    RequestBuilder requestBuilder = post("/")
        .header(HttpHeaders.AUTHORIZATION, "Basic "
            + Base64.getEncoder()
            .encodeToString(authenticationByte));

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    MockHttpServletResponse response = result.getResponse();

    assertEquals(HttpStatus.OK.value(), response.getStatus());

    String expected = "{ \"id\": \"" + userName + "\", "
        + "    \"attributes\": {  \"ROLE\": \"TEST\"  }, "
        + "    \"@class\": \"org.apereo.cas.authentication.principal.SimplePrincipal\" }";

    JSONAssert.assertEquals(expected, response.getContentAsString(), false);
  }

}
