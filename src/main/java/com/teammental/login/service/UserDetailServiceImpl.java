package com.teammental.login.service;

import com.teammental.login.entity.Authentication;
import com.teammental.login.jpa.AuthenticationRepository;
import com.teammental.login.service.rest.UserService;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

  public static final Logger LOGGER = LoggerFactory.getLogger(UserDetailServiceImpl.class);

  @Autowired
  private AuthenticationRepository authenticationRepository;

  @Autowired
  private UserService userService;


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    int userId = userService.getUserIdByUserName(username);

    LOGGER.info("********** USERNAME:" + username);

    Authentication authUser = authenticationRepository.findOne(userId);
    if (authUser == null) {
      throw new UsernameNotFoundException("UserName " + username + " not found");
    }

    User user = new User(String.valueOf(authUser.getUserId()),
        authUser.getPassword(), new ArrayList<>());

    return user;
  }

}
