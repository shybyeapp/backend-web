package com.GDI_Hackathon.ShyBye.Controllers;

import com.GDI_Hackathon.ShyBye.Daos.UserDao;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

    private UserDao userDao;

    public UserController(UserDao userDao){this.userDao = userDao;}

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> findall() {return userDao.findAll();}

    //login to app

    //pull current username and points get

}
