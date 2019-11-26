package com.santa.techtest.controller;

import com.santa.techtest.domain.Role;
import com.santa.techtest.domain.User;
import com.santa.techtest.service.RoleService;
import com.santa.techtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService){
        this.userService = userService;
        this.roleService = roleService;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}/set-roles", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean setRolesByUserId(@PathVariable("id") Long userId, @RequestBody List<Long> newRolesIds) {
        return userService.setRoles(userId, newRolesIds);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> findAllUsers(){
        return userService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}/roles", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Role> findUserRoles(@PathVariable Long id){
        return userService.getRoles(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/allRoles", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Role> findAll(){
        return roleService.findAll();
    }
}
