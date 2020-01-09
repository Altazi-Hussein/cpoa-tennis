
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

    public class ChoixDate extends Application  {

        @Override
        public void start(Stage primaryStage) throws Exception {
            primaryStage.setTitle("Button Experiment 1");
            Group root = new Group();
            Scene scene = new Scene(root, 800, 600, Color.ORANGE);
            DatePicker datePicker = new DatePicker();
            HBox hbox = new HBox(datePicker);
            primaryStage.setScene(scene);
            primaryStage.show();
            hbox.setLayoutX(400);
            hbox.setLayoutY(200);
            root.getChildren().add(hbox);


        }

        public static void main(String[] args) {
            Application.launch(ChoixDate.class, args);
        }
    }
