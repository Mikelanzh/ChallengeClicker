package com.example.sowl.challengeclicker.Repository.Model;

public class ScoreModel {
    public int ID;
    public String Avatar;
    public String Name;
    public int Score;


    public ScoreModel() {

    }

    public ScoreModel(int id, String avatar, String name, int score) {
        this.ID = id;
        this.Avatar = avatar;
        this.Name = name;
        this.Score = score;

    }
}
