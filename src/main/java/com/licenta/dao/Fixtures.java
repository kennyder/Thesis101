package com.licenta.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fixtures {

    private SimpleDateFormat df = new SimpleDateFormat ("yyyy-MM-dd'T'HH:mm:ssXXX");
    Date date;
    String league;
    String homeTeam;
    String awayTeam;

    public SimpleDateFormat getDf() {
        return df;
    }

    public void setDf(SimpleDateFormat df) {
        this.df = df;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String date) {
        try {
            this.date = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Fixtures() {
        this.df = df;
        this.date = date;
        this.league = league;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    @Override
    public String toString() {
        return "Fixtures{" +
                ", date=" + date +
                ", league='" + league + '\'' +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                '}';
    }
}
