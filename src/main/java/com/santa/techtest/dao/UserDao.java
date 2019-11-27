package com.santa.techtest.dao;

import com.santa.techtest.domain.User;

import java.util.List;

public interface UserDao {

    User create(User user);
    User findById(Long id);
    User findByEmail(String email);
    List<User> findAll();
    boolean setPackage(String username, Long tour_id);
    boolean removePackage(String username);
}
