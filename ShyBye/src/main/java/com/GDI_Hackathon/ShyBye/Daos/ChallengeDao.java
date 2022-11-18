package com.GDI_Hackathon.ShyBye.Daos;
import com.GDI_Hackathon.ShyBye.Models.Challenge;
import com.GDI_Hackathon.ShyBye.Models.CompleteChallenge;
import java.util.List;

public interface ChallengeDao {

    //submit completed challenge
    void submitCompletedChallenge(int userId, int challengeId);

    //list history of completed tasks
    List<CompleteChallenge> getUserHistory(int userId);

    //Get Completed Challenge Details By Completed_Challenge_id
    CompleteChallenge getCompletedChallengeById(int completedChallengeId);

    //Get Challenge Details by Challenge_id
    Challenge getChallengeById(int challengeId);



}
