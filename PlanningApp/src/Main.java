import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Calendar;

import java.time.LocalDate;

public class Main extends Application {
    Stage window;
    Scene scene1, scene2,scene3;
    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
//---------------Main----------------------------------------------
        Button creer = new Button();
        Button modifer = new Button();
        Text titre = new Text("Planning App");
        creer.setPrefWidth(120);
        modifer.setPrefWidth(120);
        creer.setPrefHeight(200);
        modifer.setPrefHeight(200);
        creer.setLayoutX(250);
        modifer.setLayoutX(450);
        creer.setLayoutY(200);
        modifer.setLayoutY(200);
        creer.setText("Creer");
        modifer.setText("Modifier");
        creer.setOnAction(e -> window.setScene(scene2));

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(titre,creer,modifer);
        scene1 = new Scene(layout1, 800, 400);
//------------------------------------------------------------------
//-----------------Date---------------------------------------------
        DatePicker datePicker = new DatePicker();
        HBox hbox = new HBox(datePicker);
        Button valider = new Button();
        Button ok = new Button();
        ok.setText("ok");
        valider.setText("Valider");
        valider.setOnAction(e -> window.setScene(scene3));
        String date;
        ok.setOnAction(e -> date = String.valueOf(datePicker.getValue()));
        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(hbox,ok,valider);
        scene2 = new Scene(layout2,800, 400);
//------------------------------------------------------------------

//----------------Choix type tournoi--------------------------------


        Text titreDate = new Text(date);

        StackPane layout3 = new StackPane();
        layout3.getChildren().addAll(titreDate);
        scene3 = new Scene(layout3,800,400);
//------------------------------------------------------------------


        window.setScene(scene1);
        window.setTitle("PlanningApp");
        window.show();

    }
}
