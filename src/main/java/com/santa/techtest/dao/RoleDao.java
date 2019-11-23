package com.santa.techtest.dao;

import com.santa.techtest.domain.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getRolesByUserId(Long userId);
}
