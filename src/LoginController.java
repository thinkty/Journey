import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private String hint;
    private String password;
    public AnchorPane loginFXML;
    public PasswordField passwordField;
    public Button submitButton;
    public Button hintButton;
    public Label invalidPassword;


    /**
     * Activate when submit button is clicked
     */
    public void submit() {
        if (passwordField.getText().equals(password)) {
            //If the password is correct, change the scene to view story
            Stage currentStage = (Stage) passwordField.getScene().getWindow();
            try {
                Parent viewStoryRoot = FXMLLoader.load(getClass().getResource("viewStory.fxml"));
                Scene viewStoryScene = new Scene(viewStoryRoot);
                currentStage.setScene(viewStoryScene);
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            invalidPassword.setVisible(true);
        }
    }


    /**
     * Activate when hint button is clicked
     */
    public void showHint() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Hint");
        alert.setContentText(hint);
        alert.showAndWait();
    }


    /**
     * Read the passcode.txt file for the password and the hint
     * I did not encode the password for this project
     * Make sure that you have the password file with one line for each
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try (BufferedReader br = new BufferedReader(new FileReader("src\\passcode.txt"))) {
            password = br.readLine();
            hint = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
