package com.santa.techtest.service;

import com.santa.techtest.domain.Role;
import com.santa.techtest.domain.User;

import java.util.List;

public interface UserService {

    User create(User user);
    User findById(Long id);
    User findByEmail(String email);
    List<Role> getRoles(Long id);
}
