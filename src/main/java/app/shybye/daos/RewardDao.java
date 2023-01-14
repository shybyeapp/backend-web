package app.shybye.daos;

import java.util.List;

import app.shybye.models.Reward;

public interface RewardDao {

	// pull a list of rewards
	List<Reward> getListOfRewards();

	// get reward by id
	Reward getRewardById(int rewardId);

	// pull a list of earned rewards

}
