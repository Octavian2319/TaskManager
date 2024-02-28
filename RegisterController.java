import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class RegisterController {

    @FXML
    private TextField NameField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Label RegisterText;

    @FXML
    private AnchorPane Scene2;

    @FXML
    void RegisterButton(ActionEvent event) throws IOException {
        try {
            File details = new File("details.txt");
            if (!details.exists()) {
                details.createNewFile();
            }

            System.out.println("Open with succes");
            FileWriter myWrite = new FileWriter("details.txt", true);
            myWrite.write(NameField.getText() + "," + PasswordField.getText() + "\n");

            myWrite.close();
        } catch (Exception e) {
            System.err.println("It didn't open\n" + "" + e);
        }
        String nume = "Task_" + NameField.getText() + ".txt";
        File NameFile = new File(nume);
        if (!NameFile.exists()) {
            NameFile.createNewFile();
        }
        System.out.println("Created with succes Task File");
        new SwitchScene(Scene2, "WelcomeScene.fxml");
    }

}
