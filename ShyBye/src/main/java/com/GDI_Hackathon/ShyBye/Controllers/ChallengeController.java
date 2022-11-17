package com.GDI_Hackathon.ShyBye.Controllers;

import com.GDI_Hackathon.ShyBye.Daos.ChallengeDao;
import com.GDI_Hackathon.ShyBye.Daos.UserDao;
import com.GDI_Hackathon.ShyBye.Models.CompleteChallenge;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ChallengeController {

    private ChallengeDao challengeDao;
//    private UserDao userDao;

    public ChallengeController(ChallengeDao challengeDao) {
        this.challengeDao = challengeDao;
//        this.userDao = userDao;
    }

    //submit completed challenge to database
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/challenge", method = RequestMethod.POST)
    public void submitCompletedChallenge(@RequestBody CompleteChallenge completeChallenge){
        challengeDao.submitCompletedChallenge(completeChallenge);
    }

    //pull completed challenge history from database
    @ResponseStatus(HttpStatus.FOUND)
    @RequestMapping(path = "/challenge", method = RequestMethod.GET)
    public List<CompleteChallenge> getUserChallengeHistory(@RequestParam String username){
        //int userId = userDao.getUserIdByUsername(username);
        return challengeDao.getUserHistory(userId);
    }


    //determine rewards

}
