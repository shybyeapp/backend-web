package com.GDI_Hackathon.ShyBye.Controllers;

import com.GDI_Hackathon.ShyBye.Daos.ChallengeDao;
import com.GDI_Hackathon.ShyBye.Daos.UserDao;
import com.GDI_Hackathon.ShyBye.Models.CompleteChallenge;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ChallengeController {

    private ChallengeDao challengeDao;
    private UserDao userDao;

    //submit completed challenge to database
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/challenge", method = RequestMethod.POST)
    public CompleteChallenge submitCompletedChallenge(@RequestBody CompleteChallenge completeChallenge){
        return challengeDao.submitCompletedChallenge(completeChallenge);
    }

    //pull completed challenge history from database

    //determine rewards

}
