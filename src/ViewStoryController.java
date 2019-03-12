import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewStoryController implements Initializable {

    public ScrollPane scrollPane;
    public Button addButton;
    public AnchorPane anchorPane;
    public Button reloadButton;
    private TableView<ImportantEvent> tableView;


    /**
     * Load important events.txt from the file named events.txt
     * Add to the table
     * Manage table columns
     */
    @Override
    public void initialize(URL location, ResourceBundle resources){
        ImportantEvent eventGate = new ImportantEvent();
        ArrayList<ImportantEvent> events = eventGate.loadEvents();
        ObservableList<ImportantEvent> tableEvents = FXCollections.observableArrayList();
        tableEvents.addAll(events);

        // Date
        TableColumn<ImportantEvent, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setPrefWidth(100);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        // Title
        TableColumn<ImportantEvent, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setPrefWidth(100);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        // Description
        TableColumn<ImportantEvent, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setPrefWidth(250);
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        // Location
        TableColumn<ImportantEvent, String> locationColumn = new TableColumn<>("Location");
        locationColumn.setPrefWidth(150);
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));

        tableView = new TableView<>();
        tableView.setItems(tableEvents);
        tableView.getColumns().addAll(dateColumn, titleColumn, locationColumn, descriptionColumn);

        scrollPane.setContent(tableView);
    }


    /**
     * OnClickListener for the + sign button
     * Give a new alert that will take in needed information
     */
    public void AddNewEvent(ActionEvent actionEvent) {
        Stage addNewStoryStage = new Stage();
        addNewStoryStage.setTitle(null);
        addNewStoryStage.setAlwaysOnTop(true);
        addNewStoryStage.setResizable(false);
        try {
            Parent addStoryRoot = FXMLLoader.load(getClass().getResource("addNewStory.fxml"));
            Scene addStoryScene = new Scene(addStoryRoot);
            addNewStoryStage.setScene(addStoryScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
        addNewStoryStage.show();
    }


    /**
     * Reload the events
     */
    public void ReloadEvent(ActionEvent actionEvent) {
        ImportantEvent eventGate = new ImportantEvent();
        ArrayList<ImportantEvent> events = eventGate.loadEvents();
        ObservableList<ImportantEvent> tableEvents = FXCollections.observableArrayList();
        tableEvents.addAll(events);

        // Date
        TableColumn<ImportantEvent, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setPrefWidth(100);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        // Title
        TableColumn<ImportantEvent, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setPrefWidth(100);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        // Description
        TableColumn<ImportantEvent, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setPrefWidth(250);
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        // Location
        TableColumn<ImportantEvent, String> locationColumn = new TableColumn<>("Location");
        locationColumn.setPrefWidth(150);
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));

        tableView.setItems(tableEvents);
        tableView.getColumns().addAll(dateColumn, titleColumn, locationColumn, descriptionColumn);

        scrollPane.setContent(tableView);
    }
}
