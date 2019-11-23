package com.santa.techtest.dao;

import com.santa.techtest.domain.Role;
import com.santa.techtest.mapper.RoleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {
    private JdbcTemplate jdbcTemplate;
    private RoleMapper roleMapper;
    private Logger logger = LoggerFactory.getLogger(RoleDaoImpl.class);
    @Autowired
    public RoleDaoImpl(DataSource dataSource, RoleMapper roleMapper){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.roleMapper = roleMapper;
    }

    @Override
    public List<Role> getRolesByUserId(Long userId) {
        try {
            return this.jdbcTemplate.query(Queries.SQL_GET_ROLES_BY_USER_ID, roleMapper, userId);
        } catch (Exception e) {
            logger.error("Can't get Roles by User_id = {}. Error: ", userId, e);
            throw new RuntimeException("Can't get roles by Users_id = " + userId);
        }
    }

    static class Queries{
        static final String SQL_GET_ROLES_BY_USER_ID = "SELECT \n" +
                "  \"Role\".name, \n" +
                "  \"Role\".id\n" +
                "FROM \n" +
                "  public.\"Role\", \n" +
                "  public.\"User\", \n" +
                "  public.\"Users_Roles\"\n" +
                "WHERE \n" +
                "  \"Users_Roles\".user_id = \"User\".id AND\n" +
                "  \"Users_Roles\".role_id = \"Role\".id AND \"User\".id = ?;";
    }
}
