package com.GDI_Hackathon.ShyBye.Daos;

import com.GDI_Hackathon.ShyBye.Models.Reward;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRewardDao implements RewardDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcRewardDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Reward> getListOfRewards() {
        String sql = "SELECT reward_id, reward_name, reward_description " +
                "FROM rewards; ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        List<Reward> rewards = new ArrayList<>();

        while(results.next()){
            rewards.add(mapRowToReward(results));
        }

        return rewards;
    }

    @Override
    public Reward getRewardById(int rewardId) {
        String sql = "SELECT reward_id, reward_name, reward_description " +
                "FROM rewards; ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        if(results.next()){
            return mapRowToReward(results);
        }

        throw new RuntimeException("Result Id not found");
    }


    public Reward mapRowToReward(SqlRowSet rs){
        Reward reward = new Reward();
        reward.setRewardId(rs.getInt("reward_id"));
        reward.setRewardName(rs.getString("reward_name"));
        reward.setRewardDescription(rs.getString("reward_description"));

        return reward;
    }

}
