import java.io.File;

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

    String name;
    void NamaM(String a) {
        name = a;
    }

    @FXML
    void SubmitButton(ActionEvent event) throws IOException {
        String nume = "Task_" + name + ".txt";
        String username = DataStore.getInstance().getUsername();
        System.out.println("Numele primit este " + username);
        File file = new File(nume);
        if (!file.exists()) {
            file.createNewFile();
        }

    }

    

}
