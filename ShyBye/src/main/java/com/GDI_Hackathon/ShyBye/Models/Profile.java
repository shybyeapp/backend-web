package com.GDI_Hackathon.ShyBye.Models;

public class Profile {

    private int userId;
    private String username;
    private int userPoints;

    public Profile(int userId, String username, int userPoints) {
        this.userId = userId;
        this.username = username;
        this.userPoints = userPoints;
    }

    public Profile() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserPoints() {
        return userPoints;
    }

    public void setUserPoints(int userPoints) {
        this.userPoints = userPoints;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", userPoints=" + userPoints +
                '}';
    }
}
