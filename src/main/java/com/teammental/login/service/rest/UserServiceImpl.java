package com.teammental.login.service.rest;

import org.springframework.stereotype.Service;

/**
 * Created by coskun on 26.07.2017.
 */
@Service
public class UserServiceImpl implements UserService {

  @Override
  public int getUserIdByUserName(String username) {
    //todo user uygulamasından rest ile servis alınacak.
    //todo username (email veya tcno) verilecek ve userId alınacak.
    return 1;
  }

}
