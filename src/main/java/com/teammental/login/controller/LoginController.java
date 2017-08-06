package com.teammental.login.controller;

import com.teammental.login.dto.LoginResult;
import com.teammental.mebuilder.GenericBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
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
  public ResponseEntity<LoginResult> login() {

    String userId = SecurityContextHolder.getContext().getAuthentication().getName();
    LOGGER.info("********* Giriş başarılı. UserId: " + userId);

    LoginResult loginResult = GenericBuilder.of(LoginResult::new)
        .with(LoginResult::setId, userId)
        .build();
    loginResult.getAttributes().put("ROLE", "TEST");

    return new ResponseEntity<>(loginResult, HttpStatus.OK);
  }

}
