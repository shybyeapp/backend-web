package app.shybye.daos;

import java.util.List;

import app.shybye.models.LoginDTO;
import app.shybye.models.User;

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
