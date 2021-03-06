package com.teammental.login.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Authentication tablosu mappingi.
 * Created by coskun on 16.07.2017.
 */
@Entity
@Table(name = "AUTHENTICATION")
public class Authentication {

  @Id
  @Column(name = "USER_ID", columnDefinition = "NUMERIC")
  private int userId;

  @Column(name = "PASSWORD")
  private String password;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
