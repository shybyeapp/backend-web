package app.shybye.models;

import java.time.LocalDateTime;

public class CompleteChallenge {

	private int id;
	private int userId;
	private int challengeId;
	private String journalEntry;
	// private LocalDateTime dateCompleted;

	// public CompleteChallenge(int id, int userId, int challengeId, LocalDateTime
	// 	dateCompleted) {
	// 		this.id = id;
	// 		this.userId = userId;
	// 		this.challengeId = challengeId;
	// 		this.dateCompleted = dateCompleted;
	// }

	public CompleteChallenge(int id, int userId, int challengeId) {
		this.id = id;
		this.userId = userId;
		this.challengeId = challengeId;
	}

	public CompleteChallenge() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getChallengeId() {
		return challengeId;
	}

	public void setChallengeId(int challengeId) {
		this.challengeId = challengeId;
	}

	// public LocalDateTime getDateCompleted() {
	// 	return dateCompleted;
	// }

	// public void setDateCompleted(LocalDateTime dateCompleted) {
	// 	this.dateCompleted = dateCompleted;
	// }

	@Override
	public String toString() {
		return "CompleteChallenge{" +
				"id=" + id +
				", userId=" + userId +
				", challengeId=" + challengeId +
				// ", dateCompleted=" + dateCompleted +
				"}";
	}
}
