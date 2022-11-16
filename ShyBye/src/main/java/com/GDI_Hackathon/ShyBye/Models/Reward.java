package com.GDI_Hackathon.ShyBye.Models;

public class Reward {

    private int rewardId;
    private String rewardName;
    private String rewardDescription;
    private String rewardImage;

    public Reward(int rewardId, String rewardName, String rewardDescription, String rewardImage) {
        this.rewardId = rewardId;
        this.rewardName = rewardName;
        this.rewardDescription = rewardDescription;
        this.rewardImage = rewardImage;
    }

    public Reward() {
    }

    public int getRewardId() {
        return rewardId;
    }

    public void setRewardId(int rewardId) {
        this.rewardId = rewardId;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public String getRewardDescription() {
        return rewardDescription;
    }

    public void setRewardDescription(String rewardDescription) {
        this.rewardDescription = rewardDescription;
    }

    public String getRewardImage() {
        return rewardImage;
    }

    public void setRewardImage(String rewardImage) {
        this.rewardImage = rewardImage;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "rewardId=" + rewardId +
                ", rewardName='" + rewardName + '\'' +
                ", rewardDescription='" + rewardDescription + '\'' +
                ", rewardImage='" + rewardImage + '\'' +
                '}';
    }
}
