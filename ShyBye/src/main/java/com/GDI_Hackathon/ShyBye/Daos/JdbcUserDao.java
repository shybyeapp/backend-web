package com.GDI_Hackathon.ShyBye.Daos;

import com.GDI_Hackathon.ShyBye.Models.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcUserDao implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate){ this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<User> findAll() {
        List<User> allUsers = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM users";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            User user = mapRowToUser(results);
            allUsers.add(user);
        }
        return allUsers;
    }

    @Override
    public User findByUsername(String username) {
        if (username == null) throw new IllegalArgumentException("Username cannot be null");

        for (User user : this.findAll()) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        throw new UsernameNotFoundException("User " + username + " was not found.");
    }

    @Override
    public void createUser(User newUser){
        String sql = " insert into users (username, passwrd, user_points) " +
                "values (?,?,?) RETURNING user_id; ";
        try {
            jdbcTemplate.queryForObject(sql, Integer.class ,newUser.getUserName(),newUser.getPassword(),newUser.getUserPoints())
        } catch (DataAccessException e) {
            System.out.println("Database access exception");
        }

    };



    private User mapRowToUser(SqlRowSet rs){
        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        user.setUserName(rs.getString("username"));
        user.setUserPoints(rs.getInt("user_points"));
        return user;
    }

}
