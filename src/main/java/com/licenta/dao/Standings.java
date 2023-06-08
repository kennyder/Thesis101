package com.licenta.dao;

public class Standings {

    private long spot;
    private String name;
    private long points;
    private long played;
    private long wins;
    private long defeats;
    private long draws;
    private long gf;
    private long ga;

    public long getSpot() {
        return spot;
    }

    public void setSpot(long spot) {
        this.spot = spot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public long getPlayed() {
        return played;
    }

    public void setPlayed(long played) {
        this.played = played;
    }

    public long getWins() {
        return wins;
    }

    public void setWins(long wins) {
        this.wins = wins;
    }

    public long getDefeats() {
        return defeats;
    }

    public void setDefeats(long defeats) {
        this.defeats = defeats;
    }

    public long getDraws() {
        return draws;
    }

    public void setDraws(long draws) {
        this.draws = draws;
    }

    public long getGf() {
        return gf;
    }

    public void setGf(long gf) {
        this.gf = gf;
    }

    public long getGa() {
        return ga;
    }

    public void setGa(long ga) {
        this.ga = ga;
    }

    public Standings(int spot, String name, int points, int played, int wins, int defeats, int draws, int gf, int ga) {
        this.spot = spot;
        this.name = name;
        this.points = points;
        this.played = played;
        this.wins = wins;
        this.defeats = defeats;
        this.draws = draws;
        this.gf = gf;
        this.ga = ga;
    }
    public Standings(){}
}
