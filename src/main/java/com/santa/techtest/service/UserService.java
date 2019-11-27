package com.santa.techtest.service;

import com.santa.techtest.domain.Role;
import com.santa.techtest.domain.User;
import com.santa.techtest.dto.BookDto;
import com.santa.techtest.dto.TourDto;

import java.util.List;

public interface UserService {

    User create(User user);
    User findById(Long id);
    User findByEmail(String email);
    List<Role> getRoles(Long id);
    boolean setRoles(Long userId, List<Long> newRolesIds);
    List<User> findAll();
    boolean setTour(String username, BookDto bookDto);
    TourDto getTour(String username);
    boolean removeTour(String username);
}
