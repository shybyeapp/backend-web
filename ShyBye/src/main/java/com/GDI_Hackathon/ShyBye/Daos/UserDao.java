package com.GDI_Hackathon.ShyBye.Daos;
import com.GDI_Hackathon.ShyBye.Models.LoginDTO;
import com.GDI_Hackathon.ShyBye.Models.User;
import java.util.List;

public interface UserDao {


    User login(LoginDTO login);

    List<User> findAll();

    User getUserById(int userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    void createUser(User user);

    int getPointsByUserId(int userId);

    User updateUserScore(User updatedUser);

}
