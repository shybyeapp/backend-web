package com.GDI_Hackathon.ShyBye.Models;

public class Challenge {

    private int challengeId;
    private String challengeName;
    private String challengeDescription;
    private int challengePoints;
    private String text;
    private int rewardId;

    public Challenge(int challengeId, String challengeName, String challengeDescription, int challengePoints, String text, int rewardId) {
        this.challengeId = challengeId;
        this.challengeName = challengeName;
        this.challengeDescription = challengeDescription;
        this.challengePoints = challengePoints;
        this.text = text;
        this.rewardId = rewardId;
    }

    public Challenge() {
    }

    public int getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(int challengeId) {
        this.challengeId = challengeId;
    }

    public String getChallengeName() {
        return challengeName;
    }

    public void setChallengeName(String challengeName) {
        this.challengeName = challengeName;
    }

    public String getChallengeDescription() {
        return challengeDescription;
    }

    public void setChallengeDescription(String challengeDescription) {
        this.challengeDescription = challengeDescription;
    }

    public int getChallengePoints() {
        return challengePoints;
    }

    public void setChallengePoints(int challengePoints) {
        this.challengePoints = challengePoints;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRewardId() {
        return rewardId;
    }

    public void setRewardId(int rewardId) {
        this.rewardId = rewardId;
    }

    @Override
    public String toString() {
        return "Challenge{" +
                "challengeId=" + challengeId +
                ", challengeName='" + challengeName + '\'' +
                ", challengeDescription='" + challengeDescription + '\'' +
                ", challengePoints=" + challengePoints +
                ", text='" + text + '\'' +
                ", rewardId=" + rewardId +
                '}';
    }
}
