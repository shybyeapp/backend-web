package com.GDI_Hackathon.ShyBye.Daos;

import com.GDI_Hackathon.ShyBye.Exceptions.UserIdNotFoundException;
import com.GDI_Hackathon.ShyBye.Exceptions.UsernameNotFoundException;
import com.GDI_Hackathon.ShyBye.Models.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
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
    public User getUserById(int userId) {
        String sql = "SELECT user_id, username, user_points " +
                     "FROM users " +
                     "WHERE user_id = ?; ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        if(results.next()){
            return mapRowToUser(results);
        }

        throw new UserIdNotFoundException();
    }

    @Override
    public User findByUsername(String username) {
        String sql = "SELECT user_id, username, user_points " +
                     "FROM users " +
                     "WHERE username = '?'; ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);

        if(results.next()){
            return mapRowToUser(results);
        }

        throw new UsernameNotFoundException();

//        if (username == null) throw new IllegalArgumentException("Username cannot be null");

//        for (User user : this.findAll()) {
//            if (user.getUsername().equalsIgnoreCase(username)) {
//                return user;
//            }
//        }
    }

    @Override
    public int findIdByUsername(String username) {
        return 0;
    }

    @Override
    public void createUser(User newUser){
        String sql = "INSERT INTO users (username, passwrd, user_points) " +
                     "VALUES (?,?,?) RETURNING user_id; ";
        try {
            jdbcTemplate.queryForObject(sql, Integer.class ,newUser.getUsername(),newUser.getPassword(),newUser.getUserPoints());
        } catch (DataAccessException e) {
            System.out.println("Database access exception");
        }

    }

    @Override
    public int getPointsByUserId(int userId) {
        return 0;
    }

    private User mapRowToUser(SqlRowSet rs){
        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setUserPoints(rs.getInt("user_points"));
        user.setPassword("");
        return user;
    }

}
