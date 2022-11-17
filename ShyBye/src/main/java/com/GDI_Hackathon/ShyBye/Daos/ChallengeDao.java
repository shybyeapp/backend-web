package com.GDI_Hackathon.ShyBye.Daos;

import com.GDI_Hackathon.ShyBye.Models.CompleteChallenge;

import java.util.List;

public interface ChallengeDao {

    //submit completed challenge
    void submitCompletedChallenge(CompleteChallenge completeChallenge);

    //list history of completed tasks
    List<CompleteChallenge> getUserHistory(int userId);

    //Get CompletedChallenge By id
    CompleteChallenge getCompletedChallengeById(int completedChallengeId);

    //count number of tasks completed per specific difficulty


    //count number of tasks completed per challenge id


}
