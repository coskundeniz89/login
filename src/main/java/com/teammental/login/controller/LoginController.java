package com.teammental.login.controller;

import com.teammental.login.dto.LoginResult;
import com.teammental.mebuilder.GenericBuilder;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.postgresql.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * Bu controller giriş ekranı için kullanılır.
 * Created by coskun on 25.07.2017.
 */
@RestController
public class LoginController {

  private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

  /**
   * Login controller.
   *
   * @return LoginResult
   */
  @PostMapping("/")
  public ResponseEntity<LoginResult> login(
      @RequestHeader(value = "Authorization") String authorization) {

    LOGGER.info("********* Giriş başladı.");
    LOGGER.info("********* Authorization Header: " + authorization);

    StringUtils.newStringUtf8(Base64.decode(authorization.replace("Basic ", "")));

    SecurityContextHolder.getContext().getAuthentication();

    LoginResult loginResult = GenericBuilder.of(LoginResult::new)
        .with(LoginResult::setId, "coskun")
        .with(LoginResult::setClassName, "org.apereo.cas.authentication.principal.SimplePrincipal")
        .build();

    loginResult.getAttributes().put("ROLE", "TEST");

    ResponseEntity<LoginResult> result = new ResponseEntity<>(loginResult, HttpStatus.OK);

    LOGGER.info("********* Giriş bitti");
    return result;
  }


}
