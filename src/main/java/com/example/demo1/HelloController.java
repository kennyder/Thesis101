package com.example.demo1;

import com.licenta.dao.Joc;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    MenuItem details;
    @FXML
    TextField fieldSearch;
    @FXML
    Button search;
    @FXML
    Button TablesMain;
    @FXML
    Button favorites;
    @FXML
    Button goToCompare;
    @FXML
    Button exit;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private ListView listaMeciuri;
    private ObservableList<Joc> items = FXCollections.observableArrayList();

    Stage stage;

    public void handleTablesMainBtn() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("TablesView.fxml"));
        Stage window = (Stage) favorites.getScene().getWindow();
        window.setScene(new Scene(root, 602, 638));

    }

    public void handleFavoritesBtn() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Favorites.fxml"));
        Stage window = (Stage) TablesMain.getScene().getWindow();
        window.setScene(new Scene(root, 602, 638));

    }

    public void handleSearchBtn() throws Exception{

        String teamname= fieldSearch.getText();
        ShareData sd = ShareData.getInstance();
        sd.setTeamname(teamname);
        System.out.println(".... teamname:"+ teamname);

        Parent root = FXMLLoader.load(getClass().getResource("IndividualStats.fxml"));
        Stage window = (Stage) search.getScene().getWindow();
        window.setScene(new Scene(root, 602, 638));

    }

//    public void handleDetailsButton() throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("MatchView.fxml"));
//        Stage window = (Stage) goToDetails.getScene().getWindow();
//        window.setScene(new Scene(root, 602, 638));
//    }

    public void handleCompareBtn() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("CompareStats.fxml"));
        Stage window = (Stage) goToCompare.getScene().getWindow();
        window.setScene(new Scene(root, 602, 638));
    }

    public void Exit(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to exit");
        alert.setContentText("Are you sure you want to exit?");

        if(alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("Exiting...");
            stage.close();
        }
    }


    List<Joc> getMeciuri(){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api-football-v1.p.rapidapi.com/v3/fixtures?last=50")
                .get()
                .addHeader("X-RapidAPI-Key", "25f378b6damshc17fe739842f292p139f8cjsnb5482d97aa7f")
                .addHeader("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
                .build();

//        try {
//            Response response = client.newCall(request).execute();
//            String body = response.body().string();
//           System.out.println("body: "+body);
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }

        String body = "{\"get\":\"fixtures\",\"parameters\":{\"league\":\"39\",\"round\":\"Regular Season - 10\",\"season\":\"2020\"},\"errors\":[],\"results\":10,\"paging\":{\"current\":1,\"total\":1},\"response\":[{\"fixture\":{\"id\":592231,\"referee\":\"M. Oliver\",\"timezone\":\"UTC\",\"date\":\"2020-11-29T19:15:00+00:00\",\"timestamp\":1606677300,\"periods\":{\"first\":1606677300,\"second\":1606680900},\"venue\":{\"id\":494,\"name\":\"Emirates Stadium\",\"city\":\"London\"},\"status\":{\"long\":\"Match Finished\",\"short\":\"FT\",\"elapsed\":90}},\"league\":{\"id\":39,\"name\":\"Premier League\",\"country\":\"England\",\"logo\":\"https:\\/\\/media-1.api-sports.io\\/football\\/leagues\\/39.png\",\"flag\":\"https:\\/\\/media-1.api-sports.io\\/flags\\/gb.svg\",\"season\":2020,\"round\":\"Regular Season - 10\"},\"teams\":{\"home\":{\"id\":42,\"name\":\"Arsenal\",\"logo\":\"https:\\/\\/media-2.api-sports.io\\/football\\/teams\\/42.png\",\"winner\":false},\"away\":{\"id\":39,\"name\":\"Wolves\",\"logo\":\"https:\\/\\/media-2.api-sports.io\\/football\\/teams\\/39.png\",\"winner\":true}},\"goals\":{\"home\":1,\"away\":2},\"score\":{\"halftime\":{\"home\":1,\"away\":2},\"fulltime\":{\"home\":1,\"away\":2},\"extratime\":{\"home\":null,\"away\":null},\"penalty\":{\"home\":null,\"away\":null}}},{\"fixture\":{\"id\":592232,\"referee\":\"S. Attwell\",\"timezone\":\"UTC\",\"date\":\"2020-11-28T12:30:00+00:00\",\"timestamp\":1606566600,\"periods\":{\"first\":1606566600,\"second\":1606570200},\"venue\":{\"id\":508,\"name\":\"The American Express Community Stadium\",\"city\":\"Falmer, East Sussex\"},\"status\":{\"long\":\"Match Finished\",\"short\":\"FT\",\"elapsed\":90}},\"league\":{\"id\":39,\"name\":\"Premier League\",\"country\":\"England\",\"logo\":\"https:\\/\\/media-1.api-sports.io\\/football\\/leagues\\/39.png\",\"flag\":\"https:\\/\\/media-1.api-sports.io\\/flags\\/gb.svg\",\"season\":2020,\"round\":\"Regular Season - 10\"},\"teams\":{\"home\":{\"id\":51,\"name\":\"Brighton\",\"logo\":\"https:\\/\\/media-2.api-sports.io\\/football\\/teams\\/51.png\",\"winner\":null},\"away\":{\"id\":40,\"name\":\"Liverpool\",\"logo\":\"https:\\/\\/media-1.api-sports.io\\/football\\/teams\\/40.png\",\"winner\":null}},\"goals\":{\"home\":1,\"away\":1},\"score\":{\"halftime\":{\"home\":0,\"away\":0},\"fulltime\":{\"home\":1,\"away\":1},\"extratime\":{\"home\":null,\"away\":null},\"penalty\":{\"home\":null,\"away\":null}}},{\"fixture\":{\"id\":592233,\"referee\":\"P. Tierney\",\"timezone\":\"UTC\",\"date\":\"2020-11-29T16:30:00+00:00\",\"timestamp\":1606667400,\"periods\":{\"first\":1606667400,\"second\":1606671000},\"venue\":{\"id\":519,\"name\":\"Stamford Bridge\",\"city\":\"London\"},\"status\":{\"long\":\"Match Finished\",\"short\":\"FT\",\"elapsed\":90}},\"league\":{\"id\":39,\"name\":\"Premier League\",\"country\":\"England\",\"logo\":\"https:\\/\\/media-1.api-sports.io\\/football\\/leagues\\/39.png\",\"flag\":\"https:\\/\\/media-1.api-sports.io\\/flags\\/gb.svg\",\"season\":2020,\"round\":\"Regular Season - 10\"},\"teams\":{\"home\":{\"id\":49,\"name\":\"Chelsea\",\"logo\":\"https:\\/\\/media-1.api-sports.io\\/football\\/teams\\/49.png\",\"winner\":null},\"away\":{\"id\":47,\"name\":\"Tottenham\",\"logo\":\"https:\\/\\/media-3.api-sports.io\\/football\\/teams\\/47.png\",\"winner\":null}},\"goals\":{\"home\":0,\"away\":0},\"score\":{\"halftime\":{\"home\":0,\"away\":0},\"fulltime\":{\"home\":0,\"away\":0},\"extratime\":{\"home\":null,\"away\":null},\"penalty\":{\"home\":null,\"away\":null}}},{\"fixture\":{\"id\":592234,\"referee\":\"G. Scott\",\"timezone\":\"UTC\",\"date\":\"2020-11-27T20:00:00+00:00\",\"timestamp\":1606507200,\"periods\":{\"first\":1606507200,\"second\":1606510800},\"venue\":{\"id\":525,\"name\":\"Selhurst Park\",\"city\":\"London\"},\"status\":{\"long\":\"Match Finished\",\"short\":\"FT\",\"elapsed\":90}},\"league\":{\"id\":39,\"name\":\"Premier League\",\"country\":\"England\",\"logo\":\"https:\\/\\/media-1.api-sports.io\\/football\\/leagues\\/39.png\",\"flag\":\"https:\\/\\/media-1.api-sports.io\\/flags\\/gb.svg\",\"season\":2020,\"round\":\"Regular Season - 10\"},\"teams\":{\"home\":{\"id\":52,\"name\":\"Crystal Palace\",\"logo\":\"https:\\/\\/media-3.api-sports.io\\/football\\/teams\\/52.png\",\"winner\":false},\"away\":{\"id\":34,\"name\":\"Newcastle\",\"logo\":\"https:\\/\\/media-1.api-sports.io\\/football\\/teams\\/34.png\",\"winner\":true}},\"goals\":{\"home\":0,\"away\":2},\"score\":{\"halftime\":{\"home\":0,\"away\":0},\"fulltime\":{\"home\":0,\"away\":2},\"extratime\":{\"home\":null,\"away\":null},\"penalty\":{\"home\":null,\"away\":null}}},{\"fixture\":{\"id\":592235,\"referee\":\"C. Kavanagh\",\"timezone\":\"UTC\",\"date\":\"2020-11-28T17:30:00+00:00\",\"timestamp\":1606584600,\"periods\":{\"first\":1606584600,\"second\":1606588200},\"venue\":{\"id\":8560,\"name\":\"Goodison Park\",\"city\":\"Liverpool\"},\"status\":{\"long\":\"Match Finished\",\"short\":\"FT\",\"elapsed\":90}},\"league\":{\"id\":39,\"name\":\"Premier League\",\"country\":\"England\",\"logo\":\"https:\\/\\/media-1.api-sports.io\\/football\\/leagues\\/39.png\",\"flag\":\"https:\\/\\/media-1.api-sports.io\\/flags\\/gb.svg\",\"season\":2020,\"round\":\"Regular Season - 10\"},\"teams\":{\"home\":{\"id\":45,\"name\":\"Everton\",\"logo\":\"https:\\/\\/media-2.api-sports.io\\/football\\/teams\\/45.png\",\"winner\":false},\"away\":{\"id\":63,\"name\":\"Leeds\",\"logo\":\"https:\\/\\/media-1.api-sports.io\\/football\\/teams\\/63.png\",\"winner\":true}},\"goals\":{\"home\":0,\"away\":1},\"score\":{\"halftime\":{\"home\":0,\"away\":0},\"fulltime\":{\"home\":0,\"away\":1},\"extratime\":{\"home\":null,\"away\":null},\"penalty\":{\"home\":null,\"away\":null}}},{\"fixture\":{\"id\":592236,\"referee\":\"S. Hooper\",\"timezone\":\"UTC\",\"date\":\"2020-11-30T17:30:00+00:00\",\"timestamp\":1606757400,\"periods\":{\"first\":1606757400,\"second\":1606761000},\"venue\":{\"id\":547,\"name\":\"King Power Stadium\",\"city\":\"Leicester, Leicestershire\"},\"status\":{\"long\":\"Match Finished\",\"short\":\"FT\",\"elapsed\":90}},\"league\":{\"id\":39,\"name\":\"Premier League\",\"country\":\"England\",\"logo\":\"https:\\/\\/media-1.api-sports.io\\/football\\/leagues\\/39.png\",\"flag\":\"https:\\/\\/media-1.api-sports.io\\/flags\\/gb.svg\",\"season\":2020,\"round\":\"Regular Season - 10\"},\"teams\":{\"home\":{\"id\":46,\"name\":\"Leicester\",\"logo\":\"https:\\/\\/media-1.api-sports.io\\/football\\/teams\\/46.png\",\"winner\":false},\"away\":{\"id\":36,\"name\":\"Fulham\",\"logo\":\"https:\\/\\/media-1.api-sports.io\\/football\\/teams\\/36.png\",\"winner\":true}},\"goals\":{\"home\":1,\"away\":2},\"score\":{\"halftime\":{\"home\":0,\"away\":2},\"fulltime\":{\"home\":1,\"away\":2},\"extratime\":{\"home\":null,\"away\":null},\"penalty\":{\"home\":null,\"away\":null}}},{\"fixture\":{\"id\":592237,\"referee\":\"L. Mason\",\"timezone\":\"UTC\",\"date\":\"2020-11-28T15:00:00+00:00\",\"timestamp\":1606575600,\"periods\":{\"first\":1606575600,\"second\":1606579200},\"venue\":{\"id\":555,\"name\":\"Etihad Stadium\",\"city\":\"Manchester\"},\"status\":{\"long\":\"Match Finished\",\"short\":\"FT\",\"elapsed\":90}},\"league\":{\"id\":39,\"name\":\"Premier League\",\"country\":\"England\",\"logo\":\"https:\\/\\/media-1.api-sports.io\\/football\\/leagues\\/39.png\",\"flag\":\"https:\\/\\/media-1.api-sports.io\\/flags\\/gb.svg\",\"season\":2020,\"round\":\"Regular Season - 10\"},\"teams\":{\"home\":{\"id\":50,\"name\":\"Manchester City\",\"logo\":\"https:\\/\\/media-3.api-sports.io\\/football\\/teams\\/50.png\",\"winner\":true},\"away\":{\"id\":44,\"name\":\"Burnley\",\"logo\":\"https:\\/\\/media-3.api-sports.io\\/football\\/teams\\/44.png\",\"winner\":false}},\"goals\":{\"home\":5,\"away\":0},\"score\":{\"halftime\":{\"home\":3,\"away\":0},\"fulltime\":{\"home\":5,\"away\":0},\"extratime\":{\"home\":null,\"away\":null},\"penalty\":{\"home\":null,\"away\":null}}},{\"fixture\":{\"id\":592238,\"referee\":\"J. Moss\",\"timezone\":\"UTC\",\"date\":\"2020-11-29T14:00:00+00:00\",\"timestamp\":1606658400,\"periods\":{\"first\":1606658400,\"second\":1606662000},\"venue\":{\"id\":585,\"name\":\"St. Mary's Stadium\",\"city\":\"Southampton, Hampshire\"},\"status\":{\"long\":\"Match Finished\",\"short\":\"FT\",\"elapsed\":90}},\"league\":{\"id\":39,\"name\":\"Premier League\",\"country\":\"England\",\"logo\":\"https:\\/\\/media-1.api-sports.io\\/football\\/leagues\\/39.png\",\"flag\":\"https:\\/\\/media-1.api-sports.io\\/flags\\/gb.svg\",\"season\":2020,\"round\":\"Regular Season - 10\"},\"teams\":{\"home\":{\"id\":41,\"name\":\"Southampton\",\"logo\":\"https:\\/\\/media-3.api-sports.io\\/football\\/teams\\/41.png\",\"winner\":false},\"away\":{\"id\":33,\"name\":\"Manchester United\",\"logo\":\"https:\\/\\/media-3.api-sports.io\\/football\\/teams\\/33.png\",\"winner\":true}},\"goals\":{\"home\":2,\"away\":3},\"score\":{\"halftime\":{\"home\":2,\"away\":0},\"fulltime\":{\"home\":2,\"away\":3},\"extratime\":{\"home\":null,\"away\":null},\"penalty\":{\"home\":null,\"away\":null}}},{\"fixture\":{\"id\":592239,\"referee\":\"M. Dean\",\"timezone\":\"UTC\",\"date\":\"2020-11-28T20:00:00+00:00\",\"timestamp\":1606593600,\"periods\":{\"first\":1606593600,\"second\":1606597200},\"venue\":{\"id\":597,\"name\":\"The Hawthorns\",\"city\":\"West Bromwich\"},\"status\":{\"long\":\"Match Finished\",\"short\":\"FT\",\"elapsed\":90}},\"league\":{\"id\":39,\"name\":\"Premier League\",\"country\":\"England\",\"logo\":\"https:\\/\\/media-1.api-sports.io\\/football\\/leagues\\/39.png\",\"flag\":\"https:\\/\\/media-1.api-sports.io\\/flags\\/gb.svg\",\"season\":2020,\"round\":\"Regular Season - 10\"},\"teams\":{\"home\":{\"id\":60,\"name\":\"West Brom\",\"logo\":\"https:\\/\\/media-1.api-sports.io\\/football\\/teams\\/60.png\",\"winner\":true},\"away\":{\"id\":62,\"name\":\"Sheffield Utd\",\"logo\":\"https:\\/\\/media-1.api-sports.io\\/football\\/teams\\/62.png\",\"winner\":false}},\"goals\":{\"home\":1,\"away\":0},\"score\":{\"halftime\":{\"home\":1,\"away\":0},\"fulltime\":{\"home\":1,\"away\":0},\"extratime\":{\"home\":null,\"away\":null},\"penalty\":{\"home\":null,\"away\":null}}},{\"fixture\":{\"id\":592240,\"referee\":\"P. Bankes\",\"timezone\":\"UTC\",\"date\":\"2020-11-30T20:00:00+00:00\",\"timestamp\":1606766400,\"periods\":{\"first\":1606766400,\"second\":1606770000},\"venue\":{\"id\":598,\"name\":\"London Stadium\",\"city\":\"London\"},\"status\":{\"long\":\"Match Finished\",\"short\":\"FT\",\"elapsed\":90}},\"league\":{\"id\":39,\"name\":\"Premier League\",\"country\":\"England\",\"logo\":\"https:\\/\\/media-1.api-sports.io\\/football\\/leagues\\/39.png\",\"flag\":\"https:\\/\\/media-1.api-sports.io\\/flags\\/gb.svg\",\"season\":2020,\"round\":\"Regular Season - 10\"},\"teams\":{\"home\":{\"id\":48,\"name\":\"West Ham\",\"logo\":\"https:\\/\\/media-1.api-sports.io\\/football\\/teams\\/48.png\",\"winner\":true},\"away\":{\"id\":66,\"name\":\"Aston Villa\",\"logo\":\"https:\\/\\/media-3.api-sports.io\\/football\\/teams\\/66.png\",\"winner\":false}},\"goals\":{\"home\":2,\"away\":1},\"score\":{\"halftime\":{\"home\":1,\"away\":1},\"fulltime\":{\"home\":2,\"away\":1},\"extratime\":{\"home\":null,\"away\":null},\"penalty\":{\"home\":null,\"away\":null}}}]}\n";

        List<Joc> listMeciuri=new ArrayList<Joc>();
        try {
            JSONParser parse = new JSONParser();
            JSONObject dataObject = null;
            dataObject = (JSONObject) parse.parse(body);
//            System.out.println("json");
            //Get the first JSON object in the JSON array
            JSONArray meciuri = (JSONArray) dataObject.get("response");
//
//            for (int i = 0; i <meciuri.size(); i++) {
//                JSONObject meci = (JSONObject) meciuri.get(i);
//                JSONObject actualMeci = (JSONObject) meci.get("fixture");
//                System.out.println(actualMeci.get("id"));
//                JSONObject teams = (JSONObject) meci.get("teams");
//                listMeciuri.add(actualMeci.get("id") + " " +  ((JSONObject)teams.get("home")).get("name") + " - " + ((JSONObject)teams.get("away")).get("name"));
//            }
            for (int i = 0; i <meciuri.size(); i++) {
                Joc joc = new Joc();
                JSONObject meci = (JSONObject) meciuri.get(i);
                JSONObject actualMeci = (JSONObject) meci.get("fixture");
                joc.setDate((String)actualMeci.get("date"));
                JSONObject liga = (JSONObject) meci.get("league");
                joc.setLeague((String)liga.get("name"));
                JSONObject teams = (JSONObject) meci.get("teams");
                JSONObject homeTeam = (JSONObject) teams.get("home");
                JSONObject awayTeam = (JSONObject) teams.get("away");
                JSONObject goals = (JSONObject) meci.get("goals");
                joc.setHomeTeam((String)homeTeam.get("name"));
                joc.setAwayTeam((String)awayTeam.get("name"));
                joc.setHomeGoals((Long) goals.get("home"));
                joc.setAwayGoals((Long)goals.get("away"));
                listMeciuri.add(joc);
//                System.out.println(actualMeci.get("id"));
//                JSONObject teams = (JSONObject) meci.get("teams");
//                listMeciuri.add(actualMeci.get("id") + " " +  ((JSONObject)teams.get("home")).get("name") + " - " + ((JSONObject)teams.get("away")).get("name"));
          }

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
return listMeciuri;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Joc> meciuri  = getMeciuri();
        listaMeciuri.setItems(items);
        for(Joc meci:meciuri)
           items.add(meci);

    }
}

