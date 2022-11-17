package com.GDI_Hackathon.ShyBye.Daos;

import com.GDI_Hackathon.ShyBye.Exceptions.CompletedChallengeNotFoundException;
import com.GDI_Hackathon.ShyBye.Models.CompleteChallenge;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcChallengeDao implements ChallengeDao{

    private JdbcTemplate jdbcTemplate;

    @Override
    public CompleteChallenge submitCompletedChallenge(CompleteChallenge completeChallenge) {
        String sql = "INSERT INTO completed_challenges (user_id_fk, challenge_id_fk) " +
                     "VALUES (?,?) " +
                     "RETURNING completed_challenge_id;";

        Integer completedChallengeId = 0;
        try {
            completedChallengeId = jdbcTemplate.queryForObject(sql, Integer.class,
                    completeChallenge.getUserId(), completeChallenge.getChallengeId());
        } catch (DataAccessException e) {
            System.out.println("Database access exception");
        }

        return getCompletedChallengeById(completedChallengeId);
    }

    @Override
    public List<CompleteChallenge> getUserHistory(int userId) {
        List<CompleteChallenge> history = new ArrayList<>();

        String sql = "SELECT completed_challenge_id, challenge_id " +
                     "FROM completed_challenge " +
                     "WHERE user_id_fk = ?; ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);


        while(results.next()){
            history.add(mapToCompleteChallenge(results));
        }

        return history;
    }

    @Override
    public CompleteChallenge getCompletedChallengeById(int completedChallengeId) {
        String sql = "SELECT user_id_fk, challenge_id " +
                     "FROM completed_challenge " +
                     "WHERE completed_challenge_id = ?; ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, completedChallengeId);

        if(results.next()){
            return mapToCompleteChallenge(results);
        }

        throw new CompletedChallengeNotFoundException();
    }

    private CompleteChallenge mapToCompleteChallenge(SqlRowSet rs){
        CompleteChallenge completeChallenge = new CompleteChallenge();
        completeChallenge.setChallengeId(rs.getInt("challenge_id_fk"));
        completeChallenge.setUserId(rs.getInt("user_id_fk"));
        completeChallenge.setId(rs.getInt("completed_challenge_id"));
        completeChallenge.
        return completeChallenge;
    }
}
