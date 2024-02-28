import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AddController {

    @FXML
    private AnchorPane AddScene;

    @FXML
    private DatePicker Date;

    @FXML
    private TextArea TextArea;

    @FXML
    private TextField TitleField;

    @FXML
    void SubmitButton(ActionEvent event) throws IOException {

        String username = DataStore.getInstance().getUsername();// return in username
        System.out.println("Numele primit este " + username);
        String nume = "Task_" + username + ".txt";
        File file = new File(nume);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter writer = new FileWriter(nume, true);
        writer.write(TitleField.getText() + "\n" + TextArea.getText() + "\n" + Date.getValue() + "\n" + "~\n");
        writer.close();
        new SwitchScene(AddScene, "MainPage.FXML");

    }

}
