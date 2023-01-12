package app.shybye.daos;

import java.util.List;

import app.shybye.models.Challenge;
import app.shybye.models.CompleteChallenge;

public interface ChallengeDao {

	// submit completed challenge
	void submitCompletedChallenge(int userId, int challengeId);

	// list history of completed tasks
	List<CompleteChallenge> getUserHistory(int userId);

	// Get Completed Challenge Details By Completed_Challenge_id
	CompleteChallenge getCompletedChallengeById(int completedChallengeId);

	// Get Challenge Details by Challenge_id
	Challenge getChallengeById(int challengeId);

	// Get List of all challenges
	List<Challenge> getListOfChallenges();

}
