import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This application is used for storing important events.txt in my life
 *
 * @author Tae Yoon Kim
 * @version 2019-Mar-10
 */

public class MainRunner extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Journey");

        try {

            //Start with the login scene

            Parent loginRoot = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene loginScene = new Scene(loginRoot);
            primaryStage.setScene(loginScene);
            primaryStage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
