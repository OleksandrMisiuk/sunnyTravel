package com.santa.techtest.dao;

import com.santa.techtest.domain.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getRolesByUserId(Long userId);
    List<Role> findAll();
    boolean addRoleToUser(Long userId, Long roleId);
    boolean removeRoleFromUser(Long userId, Long roleId);
}
