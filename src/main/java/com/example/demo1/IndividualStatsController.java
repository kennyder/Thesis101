package com.example.demo1;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IndividualStatsController implements Initializable {

    @FXML
    Button backToMain;
    @FXML
    Button exit;
    @FXML
    private AnchorPane scenePane;
    @FXML
    Label Name;
    Stage stage;

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

    public void handleBackToMainBtn() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage window = (Stage) backToMain.getScene().getWindow();
        window.setScene(new Scene(root, 602, 638));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ShareData sd = ShareData.getInstance();
    String teamName = sd.getTeamname();
    System.out.println("teamName " + teamName);
    Name.setText(teamName + " " + Name.getText());

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api-football-v1.p.rapidapi.com/v3/teams?name=" + teamName)
                .get()
                .addHeader("X-RapidAPI-Key", "25f378b6damshc17fe739842f292p139f8cjsnb5482d97aa7f")
                .addHeader("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
                .build();
        String body = null;

        if (sd.getUseAPI()) {

            try {
                Response response = client.newCall(request).execute();
                body = response.body().string();
                System.out.println("body: " + body);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }else
            body = "{\"get\":\"teams\",\"parameters\":{\"name\":\"Chelsea\"},\"errors\":[],\"results\":1,\"paging\":{\"current\":1,\"total\":1},\"response\":[{\"team\":{\"id\":49,\"name\":\"Chelsea\",\"code\":\"CHE\",\"country\":\"England\",\"founded\":1905,\"national\":false,\"logo\":\"https:\\/\\/media-2.api-sports.io\\/football\\/teams\\/49.png\"},\"venue\":{\"id\":519,\"name\":\"Stamford Bridge\",\"address\":\"Fulham Road\",\"city\":\"London\",\"capacity\":41841,\"surface\":\"grass\",\"image\":\"https:\\/\\/media-2.api-sports.io\\/football\\/venues\\/519.png\"}}]}\n";
    }

}
