package com.example.demo1;

public class ShareData {
    private static ShareData instance= null;

    public boolean getUseAPI() {
        return useAPI;
    }

    private boolean useAPI = false; //true

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    private String teamname;
    private ShareData(){

    }
    public static ShareData getInstance(){
        if (instance ==null){
            instance = new ShareData();
        }
        return instance;
    }
}
