package com.santa.techtest.dao;

import com.santa.techtest.domain.User;

public interface UserDao {

    User create(User user);
    User findById(Long id);
    User findByEmail(String email);

}
