package com.teammental.login.dto;

/**
 * LoginDto giriş ekranındaki değerlerdir.
 * Created by coskun on 25.07.2017.
 */
public class LoginDto {

  private LoginDto() {
  }

  //Email veya T.C no
  //todo İlerdeki aşamalarda cep telefonu ile giriş özelliği eklenebilir.
  private String userName;
  private String password;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
