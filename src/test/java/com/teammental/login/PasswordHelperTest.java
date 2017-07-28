package com.teammental.login;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.teammental.login.helper.PasswordHelper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PasswordHelper class test.
 * Created by coskun on 26.07.2017.
 */
public class PasswordHelperTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(PasswordHelperTest.class);

  @Test
  public void matchPasswordSuccess() {
    String password = "123";
    String encodedPassword = PasswordHelper.encodePassword(password);
    LOGGER.info("Encoded Password: " + encodedPassword);
    assertTrue(PasswordHelper.matchPassword(password, encodedPassword));
  }

  @Test
  public void matchPasswordFail() {
    String password = "123";
    String encodedPassword = PasswordHelper.encodePassword("1234");
    assertFalse(PasswordHelper.matchPassword(password, encodedPassword));
  }

}
