package com.teammental.login.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Login sonucundaki bilgileri Apereo Cas için sağlar.
 * Created by coskun on 25.07.2017.
 */
public class LoginResult {

  @JsonProperty("@class")
  private String className;
  private String id;
  private final Map<String, Object> attributes;

  public LoginResult() {
    attributes = new HashMap<String, Object>();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Map<String, Object> getAttributes() {
    return attributes;
  }

  @Override
  public String toString() {
    return "ClassLoginResult [id = " + id + ", attributes = " + attributes + "]";
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }
}
