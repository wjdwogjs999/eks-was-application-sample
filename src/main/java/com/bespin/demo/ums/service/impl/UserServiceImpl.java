package com.bespin.demo.ums.service.impl;

import com.bespin.demo.ums.entity.User;
import com.bespin.demo.ums.service.UserService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
  private static Map<Long, User> userMap = new HashMap<>();
  private static Long index = 4L;

  static {
    User dave = new User(1L, "dave.kim", "dave@demo.com");
    User bodoru = new User(2L, "bodoru.jung", "bodoru@demo.com");
    User arthas = new User(3L, "arthas.choi", "arthas@demo.com");
    User adam = new User(4L, "adam.seo", "adam@demo.com");
    userMap.put(dave.getId(), dave);
    userMap.put(bodoru.getId(), bodoru);
    userMap.put(arthas.getId(), arthas);
    userMap.put(adam.getId(), adam);
  }

  private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

  @Override
  public List<User> fetchUsers() {
    LOGGER.info("fetch User List");
    return new ArrayList<>(userMap.values());
  }

  @Override
  public User fetch(Long id) {
    LOGGER.info("fetch User Id : {}", id);
    return userMap.get(id);
  }

  @Override
  public User create(User user) {
    LOGGER.info("create user {}", user);
    index += 1L;
    user.setId(index);
    userMap.put(index, user);
    return user;
  }

  @Override
  public User update(Long id, User user) {
    LOGGER.info("update user id {}", id);
    User foundUser = fetch(id);
    foundUser.setName(user.getName());
    foundUser.setEmail(user.getEmail());
    userMap.put(foundUser.getId(), foundUser);
    return foundUser;
  }

  @Override
  public void delete(Long id) {
    LOGGER.info("delete user.");
    userMap.remove(id);
  }
}
