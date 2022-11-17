package com.GDI_Hackathon.ShyBye.Controllers;

import com.GDI_Hackathon.ShyBye.Daos.ChallengeDao;
import com.GDI_Hackathon.ShyBye.Daos.UserDao;
import com.GDI_Hackathon.ShyBye.Models.CompleteChallenge;
import com.GDI_Hackathon.ShyBye.Models.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ChallengeController {

    private ChallengeDao challengeDao;
    private UserDao userDao;

    public ChallengeController(ChallengeDao challengeDao, UserDao userDao) {
        this.challengeDao = challengeDao;
        this.userDao = userDao;
    }

    //submit completed challenge to database
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/challenge", method = RequestMethod.POST)
    public void submitCompletedChallenge(@RequestBody CompleteChallenge completeChallenge){
        challengeDao.submitCompletedChallenge(completeChallenge);
    }

    //pull user's completed challenge history by userId
    @ResponseStatus(HttpStatus.FOUND)
    @RequestMapping(path = "/users/{userId}/challenges", method = RequestMethod.GET)
    public List<CompleteChallenge> getUserChallengeHistory(@PathVariable int userId){
        return challengeDao.getUserHistory(userId);
    }

    @ResponseStatus(HttpStatus.FOUND)
    @RequestMapping(path = "/users/{userId}", method = RequestMethod.GET)
    public User getUserByUserId(@PathVariable int userId){
        return userDao.getUserById(userId);
    }


    //determine rewards

}
