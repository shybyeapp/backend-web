package com.GDI_Hackathon.ShyBye.Daos;

import com.GDI_Hackathon.ShyBye.Models.Reward;

import java.util.List;

public interface RewardDao {

    //pull a list of rewards
    List<Reward> getListOfRewards();

    //get reward by id
    Reward getRewardById(int rewardId);


    //pull a list of earned rewards

}
