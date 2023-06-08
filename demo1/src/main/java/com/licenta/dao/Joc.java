package com.licenta.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Joc extends Fixtures {

    private SimpleDateFormat df = new SimpleDateFormat ("yyyy-MM-dd'T'HH:mm:ssXXX");
    Date date;
    String league;
    String homeTeam;
    String awayTeam;
    long homeGoals;
    long awayGoals;

    public long getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(long homeGoals) {
        this.homeGoals = homeGoals;
    }

    public void setAwayGoals(long awayGoals) {
        this.awayGoals = awayGoals;
    }

    public long getAwayGoals() {
        return awayGoals;
    }

    public Date getDate() {
        return date;
    }

    public String getLeague() {
        return league;
    }


    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public void setDate(String date) {
        try {
            this.date = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void setLeague(String league) {
        this.league = league;
    }


    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    @Override
    public String toString() {
        return date + "  " + league + "  " + homeTeam + " " + homeGoals +  " - "  + awayGoals + " " + awayTeam;
    }

    public Joc () {

    }

    public Joc(Date date, String league, String teams, String homeTeam, String awayTeam, int homeGoals, int awayGoals) {
        this.date = date;
        this.league = league;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }
}
