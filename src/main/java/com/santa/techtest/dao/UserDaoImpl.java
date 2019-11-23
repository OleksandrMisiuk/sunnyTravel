package com.santa.techtest.dao;

import com.santa.techtest.domain.User;
import com.santa.techtest.mapper.UserMapper;
import com.santa.techtest.utils.EncryptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;
    private PasswordEncoder passwordEncoder;
    private UserMapper mapper;
    private Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    public UserDaoImpl(DataSource dataSource, UserMapper mapper) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.passwordEncoder = new EncryptionUtil();
        this.mapper = mapper;
    }

    @Override
    public User create(User user) {
        try {
            String encryptedPassword = passwordEncoder.encode(user.getPassword());
            jdbcTemplate.update(Queries.SQL_CREATE_USER,user.getUsername(),encryptedPassword,true);
            return user;
        }
        catch (Exception e) {
            throw new RuntimeException("Create user exception");
        }

    }

    @Override
    public User findById(Long id) {
        try {
            return jdbcTemplate.queryForObject(Queries.SQL_SELECT_USER_BY_ID,
                    mapper, (Long) id);
        }
        catch (EmptyResultDataAccessException ex) {
            throw new RuntimeException("User not found" + id);
        }
        catch (Exception e) {
            logger.error("Get user (id = {}) exception. Message: {}", id, e.getMessage());
            throw new RuntimeException("Get user exception");
        }
    }

    @Override
    public User findByEmail(String email) {
        try {
            return jdbcTemplate.queryForObject(Queries.SQL_SELECT_USER_BY_EMAIL,
                    mapper, email);
        }
        catch (EmptyResultDataAccessException ex) {
            RuntimeException notFoundException = new RuntimeException("User not found");
            logger.error("Runtime exception. User not found (email = {}). Message: {}",
                    email, notFoundException.getMessage());

            throw notFoundException;
        }
        catch (Exception e) {
            logger.error("Get user (email = {}) exception. Message: {}", email, e.getMessage());
            throw new RuntimeException("Get user exception");
        }
    }

    private PreparedStatement createStatement(User user, String encryptedPassword, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(
                Queries.SQL_CREATE_USER, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, user.getUsername());
        ps.setString(2, encryptedPassword);
        ps.setBoolean(3, user.isActive());

        return ps;
    }

    static class Queries {
        static final String SQL_CREATE_USER = "" +
                "INSERT INTO public.\"User\"(username,password,is_active)" +
                " VALUES(?, ?, ?)";

        static final String SQL_SELECT_USER_BY_ID = "SELECT * FROM public.\"User\" WHERE id = ?";

        static final String SQL_SELECT_USER_BY_EMAIL = "SELECT * FROM public.\"User\" WHERE username = ?";

    }
}
