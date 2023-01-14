package app.shybye.daos;

import app.shybye.exceptions.ChallengeNotFoundException;
import app.shybye.exceptions.CompletedChallengeNotFoundException;
import app.shybye.models.Challenge;
import app.shybye.models.CompleteChallenge;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcChallengeDao implements ChallengeDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcChallengeDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void submitCompletedChallenge(int userId, int challengeId) {
		String sql = "INSERT INTO completed_challenges (user_id_fk, challenge_id_fk) " +
				"VALUES (?,?) " +
				"RETURNING completed_challenge_id; ";

		Integer completedChallengeId = 0;
		try {
			completedChallengeId = jdbcTemplate.queryForObject(sql, Integer.class,
					userId, challengeId);
		} catch (DataAccessException e) {
			System.out.println("Database access exception");
		}
	}

	// @Override
	// public int currentUserScore(int userId) {
	// String sql = "SELECT user_id_fk, sum(challenges.challenge_points) AS score "
	// +
	// "FROM completed_challenges " +
	// "JOIN challenges on challenges.challenge_id =
	// completed_challenges.challenge_id_fk " +
	// "WHERE user_id_fk = ? " +
	// "GROUP BY completed_challenges.user_id_fk;";
	//
	// return 0;
	// }

	@Override
	public List<CompleteChallenge> getUserHistory(int userId) {
		List<CompleteChallenge> history = new ArrayList<>();

		String sql = "SELECT completed_challenge_id, challenge_id_fk, user_id_fk " +
				"FROM completed_challenges " +
				"WHERE user_id_fk = ?; ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

		while (results.next()) {
			history.add(mapToCompleteChallenge(results));
		}

		return history;
	}

	@Override
	public CompleteChallenge getCompletedChallengeById(int completedChallengeId) {
		String sql = "SELECT user_id_fk, challenge_id_fk " +
				"FROM completed_challenges " +
				"WHERE completed_challenge_id = ?; ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, completedChallengeId);

		if (results.next()) {
			return mapToCompleteChallenge(results);
		}

		throw new CompletedChallengeNotFoundException();
	}

	@Override
	public Challenge getChallengeById(int challengeId) {
		String sql = "SELECT challenge_id, challenge_name, challenge_description, challenge_points, difficulty, reward_id_fk "
				+
				"FROM challenges " +
				"WHERE challenge_id = ?; ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, challengeId);

		if (results.next()) {
			return mapRowToChallenge(results);
		}

		throw new ChallengeNotFoundException();
	}

	@Override
	public List<Challenge> getListOfChallenges() {
		String sql = "SELECT challenge_id, challenge_name, challenge_description, challenge_points, difficulty, reward_id_fk "
				+
				"FROM challenges; ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

		List<Challenge> challenges = new ArrayList<>();

		while (results.next()) {
			challenges.add(mapRowToChallenge(results));
		}

		return challenges;
	}

	private CompleteChallenge mapToCompleteChallenge(SqlRowSet rs) {
		CompleteChallenge completeChallenge = new CompleteChallenge();
		completeChallenge.setId(rs.getInt("completed_challenge_id"));
		completeChallenge.setUserId(rs.getInt("user_id_fk"));
		completeChallenge.setChallengeId(rs.getInt("challenge_id_fk"));
		// completeChallenge.setDateCompleted(rs.getDate("completionDate"));
		return completeChallenge;
	}

	private Challenge mapRowToChallenge(SqlRowSet rs) {
		Challenge challenge = new Challenge();
		challenge.setChallengeId(rs.getInt("challenge_id"));
		challenge.setChallengeName(rs.getString("challenge_name"));
		challenge.setChallengeDescription(rs.getString("challenge_description"));
		challenge.setChallengePoints(rs.getInt("challenge_points"));
		challenge.setDifficulty(rs.getString("difficulty"));
		challenge.setRewardId(rs.getInt("reward_id_fk"));

		return challenge;
	}
}
