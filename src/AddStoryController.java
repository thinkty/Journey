import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddStoryController {
    public TextField dateTextField;
    public TextField titleTextField;
    public TextField locationTextField;
    public TextArea descriptionTextArea;

    private String date;
    private String title;
    private String location;
    private String description;


    /**
     * Check if the input information are valid
     * - date should be 8 characters with all digits
     * - Title, location, description can be whatever
     */
    public void confirmClicked(ActionEvent actionEvent) {
        date = dateTextField.getText();
        date = date.replaceAll("/", "");
        boolean validDate = false;

        if (date.length() == 8) {
            int count = 0;
            for (int i = 0; i < 8; i++) {
                char temp = date.charAt(i);
                if(Character.isDigit(temp)) {
                    count++;
                }
            }
            if (count == 8) {
                validDate = true;
            }
        }

        if (!validDate) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Wrong date format!");
            alert.showAndWait();
        } else {
            title = titleTextField.getText();
            location = locationTextField.getText();
            description = descriptionTextArea.getText();
            ImportantEvent event = new ImportantEvent(date, title, description, location);
            if(event.addEvent(event)) {
                Stage currentStage = (Stage) dateTextField.getScene().getWindow();
                currentStage.close();
            }
        }
    }

    /**
     * Cancel button clicked
     * Close current stage and go back to the former stage
     */
    public void cancelClicked(ActionEvent actionEvent) {
        Stage currentStage = (Stage) dateTextField.getScene().getWindow();
        currentStage.close();
    }
}
