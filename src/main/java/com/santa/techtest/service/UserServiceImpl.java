package com.santa.techtest.service;

import com.santa.techtest.dao.RoleDao;
import com.santa.techtest.dao.TourDao;
import com.santa.techtest.dao.UserDao;
import com.santa.techtest.dao.UserDaoImpl;
import com.santa.techtest.domain.Role;
import com.santa.techtest.domain.User;
import com.santa.techtest.dto.BookDto;
import com.santa.techtest.dto.TourDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service("usrService")
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserDao userDao;
    private RoleDao roleDao;
    private TourDao tourDao;
    @Autowired
    public UserServiceImpl(UserDaoImpl userDao, RoleDao roleDao, TourDao tourDao){
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.tourDao = tourDao;
    }

    @Override
    public User create(User user) {
        return userDao.create(user);
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public List<Role> getRoles(Long id) {
        return roleDao.getRolesByUserId(id);
    }

    @Override
    public boolean setRoles(Long userId, List<Long> newRolesIds) {
        List<Long> existingRolesIds = roleDao.findAll()
                .stream().flatMap(r -> Stream.of(r.getId())).collect(Collectors.toList());

        List<Long> currentRolesIds = roleDao.getRolesByUserId(userId)
                .stream().flatMap(r -> Stream.of(r.getId())).collect(Collectors.toList());

        // Adding new roles
        for (Long roleId : newRolesIds) {
            if (!currentRolesIds.contains(roleId) && existingRolesIds.contains(roleId)) {
                roleDao.addRoleToUser(userId, roleId);
            }
        }
        // Removing non-actual roles
        for (Long roleId : currentRolesIds) {
            if (!newRolesIds.contains(roleId)) {
                roleDao.removeRoleFromUser(userId, roleId);
            }
        }
        return true;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public boolean setTour(String username, BookDto bookDto) {
        boolean f = tourDao.setTour(bookDto);
        long id = tourDao.getTourId(bookDto);

        return userDao.setPackage(username, id)&&f;
    }

    @Override
    public TourDto getTour(String username) {
        return tourDao.getPackageByUserId(username);
    }

    @Override
    public boolean removeTour(String username) {
        Long tourId = tourDao.getTourIdByUsername(username);
        return userDao.removePackage(username)&&tourDao.removeTour(tourId);
    }

    @Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.findByEmail(s);
        List<Role> rolesByUserId = roleDao.getRolesByUserId(user.getId());
        user.setAuthorities(rolesByUserId);
        return user;
    }
}
