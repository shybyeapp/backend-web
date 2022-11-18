package com.GDI_Hackathon.ShyBye.Daos;

import com.GDI_Hackathon.ShyBye.Exceptions.InvalidUsernamePasswordException;
import com.GDI_Hackathon.ShyBye.Exceptions.UserIdNotFoundException;
import com.GDI_Hackathon.ShyBye.Exceptions.UsernameNotFoundException;
import com.GDI_Hackathon.ShyBye.Models.LoginDTO;
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
    public User login(LoginDTO login) {
        String sql = "SELECT user_id, username, user_points, passwrd " +
                     "FROM users " +
                     "WHERE username = ? AND passwrd = ?; ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, login.getUsername(), login.getPassword());

        if(results.next()) {
            return mapRowToUser(results);
        }

        throw new InvalidUsernamePasswordException();
    }

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
                     "WHERE username = ?; ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);

        if(results.next()){
            return mapRowToUser(results);
        }

        throw new UsernameNotFoundException();
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

    @Override
    public User updateUserScore(User updatedUser) {
        String sql = "UPDATE users " +
                     "SET user_points = ? " +
                     "WHERE user_id = ?; ";

        jdbcTemplate.update(sql, updatedUser.getUserPoints(), updatedUser.getUserId());

        return getUserById(updatedUser.getUserId());
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
