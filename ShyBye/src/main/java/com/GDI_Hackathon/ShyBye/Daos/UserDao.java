package com.GDI_Hackathon.ShyBye.Daos;
import com.GDI_Hackathon.ShyBye.Models.User;
import java.util.List;

public interface UserDao {


    List<User> findAll();

    User getUserById(int userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

     void createUser(User user);

    int getPointsByUserId(int userId);

}
