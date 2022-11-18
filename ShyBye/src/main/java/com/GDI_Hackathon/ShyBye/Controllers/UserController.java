package com.GDI_Hackathon.ShyBye.Controllers;

import com.GDI_Hackathon.ShyBye.Daos.UserDao;
import com.GDI_Hackathon.ShyBye.Models.LoginDTO;
import com.GDI_Hackathon.ShyBye.Models.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    private UserDao userDao;

    public UserController(UserDao userDao){this.userDao = userDao;}

    //list all users
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> findall() {return userDao.findAll();}

    //login to app
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public User login(@RequestBody LoginDTO login) {
        return userDao.login(login);
    }

    //Register new User
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void registerNewUser(@RequestBody User newUser){userDao.createUser(newUser);}
}
