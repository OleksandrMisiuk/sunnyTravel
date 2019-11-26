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
            logger.error("Can't get Roles by User_id = {}. Error:{} ", userId, e);
            throw new RuntimeException("Can't get roles by Users_id = " + userId);
        }
    }

    @Override
    public List<Role> findAll() {
        try {
            return this.jdbcTemplate.query(Queries.SQL_GET_ROLES, roleMapper);
        } catch (Exception e) {
            logger.error("Can't get all Roles. Error: " + e.getMessage());
            throw new RuntimeException("Can't get all Roles");
        }
    }

    @Override
    public boolean addRoleToUser(Long userId, Long roleId) {
        try {
            jdbcTemplate.update(Queries.SQL_ADD_ROLE_TO_USER, userId, roleId);
            return true;
        } catch (Exception e) {
            logger.error("Can't insert values(userID, roleID): " + userId + " " + roleId + " into Users_roles." + e.getMessage());
            throw new RuntimeException("Insert Users_roles error");
        }
    }

    @Override
    public boolean removeRoleFromUser(Long userId, Long roleId) {
        try {
            int rowsAffected = jdbcTemplate.update(Queries.SQL_REMOVE_ROLE_FROM_USER, userId, roleId);
            return rowsAffected > 0;
        } catch (Exception e) {
            logger.error("Can't delete from Users_roles  with values(userID, roleID): " + userId + " " + roleId + " " + e.getMessage());
            throw new RuntimeException("Delete from Users_roles error");
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

        static final String SQL_GET_ROLES = "SELECT * from public.\"Role\";";
        static final String SQL_ADD_ROLE_TO_USER = "Insert into " +
                "public.\"Users_Roles\"(user_id,role_id) " +
                "values (?,?);";
        static final String SQL_REMOVE_ROLE_FROM_USER = "delete from public.\"Users_Roles\" Where user_id = ? AND role_id = ?;";
    }
}
