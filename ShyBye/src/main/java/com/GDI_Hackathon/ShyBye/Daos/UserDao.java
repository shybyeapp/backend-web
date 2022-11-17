package com.GDI_Hackathon.ShyBye.Daos;

public interface UserDao {

<<<<<<< Updated upstream

=======
    List<User> findAll();

    User getUserById(int userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

     int createUser(User user);

    int getPointsByUserId(int userId);
>>>>>>> Stashed changes

}
