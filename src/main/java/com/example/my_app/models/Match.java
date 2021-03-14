package com.example.my_app.models;

public class Match {
    private String round;
    private String date;
    private String team1;
    private String ft;
    private String team2;

    public Match(String round, String date, String team1, String ft, String team2) {
        this.round = round;
        this.date = date;
        this.team1 = team1;
        this.ft = ft;
        this.team2 = team2;
    }

    public String getRound() {
        return round;
    }

    public String getDate() {
        return date;
    }

    public String getTeam1() {
        return team1;
    }

    public String getFt() {
        return ft;
    }

    public String getTeam2() {
        return team2;
    }

    @Override
    public String toString() {
        return "Match{" +
                "round='" + round + '\'' +
                ", date='" + date + '\'' +
                ", team1='" + team1 + '\'' +
                ", ft='" + ft + '\'' +
                ", team2='" + team2 + '\'' +
                '}';
    }
}
