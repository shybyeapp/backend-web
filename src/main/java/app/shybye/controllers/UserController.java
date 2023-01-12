package app.shybye.controllers;

import app.shybye.daos.UserDao;
import app.shybye.models.LoginDTO;
import app.shybye.models.User;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

	private UserDao userDao;

	public UserController(UserDao userDao) {
		this.userDao = userDao;
	}

	// list all users
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> findall() {
		return userDao.findAll();
	}

	// get user by id
	@ResponseStatus(HttpStatus.FOUND)
	@RequestMapping(path = "/users/{userId}", method = RequestMethod.GET)
	public User getUserByUserId(@PathVariable int userId) {
		return userDao.getUserById(userId);
	}

	// login to app
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public User login(@RequestBody LoginDTO login) {
		return userDao.login(login);
	}

	// Register new User
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public void registerNewUser(@RequestBody User newUser) {
		userDao.createUser(newUser);
	}
}
