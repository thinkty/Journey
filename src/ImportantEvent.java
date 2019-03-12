import javafx.scene.control.Alert;
import java.io.*;
import java.util.ArrayList;

public class ImportantEvent {

    private ArrayList<ImportantEvent> events;
    public String date;          // ex: 20190311             (8 characters long)
    public String title;         // ex: mundane day=
    public String description;   // ex: I had a nice coffee; (always end with a semi colon)
    public String location;      // ex: Purdue University


    public ImportantEvent(String date, String title, String description, String location) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.location = location;
    }


    /**
     * The String should be in this format:
     * YYYYMMDDtitle=description;location\n
     *
     * @param rawString string to be formatted
     */
    public ImportantEvent(String rawString) {
        this.date = rawString.substring(0,8);                              // First 8 characters are date
        this.title = rawString.substring(8, rawString.indexOf('='));       // Don't include the '=' sign
        this.location = rawString.substring(rawString.indexOf('=') + 1, rawString.indexOf(';'));
        this.description = rawString.substring(rawString.indexOf(';') + 1);
    }


    public ImportantEvent() {
        super();
    }


    /**
     * Append to the events.txt file
     * Don't forget to re-load the events after adding it
     *
     * @param event an event to add
     * @return true if successful
     */
    public boolean addEvent(ImportantEvent event) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/events.txt", true))) {
            bw.write(event.toString());

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Error while adding event!");
            alert.showAndWait();
            e.printStackTrace();
            return false;
        }

        return true;
    }


    /**
     * Read from the events.txt file and return an array of
     * important events
     *
     * @return an array of important events
     */
    public ArrayList<ImportantEvent> loadEvents() {
        events = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/events.txt"))) {
            String buffer;
            while ((buffer = br.readLine()) != null) {
                events.add(new ImportantEvent(buffer));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Error while loading events!");
            alert.showAndWait();
            e.printStackTrace();
        }

        return events;
    }


    /**
     * Events happened in the past should not be deleted whether it be a
     * good memory or a bad one
     * Actually, I'm just lazy to create this method
     *
     * @param event an event to be deleted
     */
    public void deleteEvent(ImportantEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(null);
        alert.setContentText("Why do you want to delete a memory?");
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return date + title + "=" + location + ";" + description + "\n";
    }
}
