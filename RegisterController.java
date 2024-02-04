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
        new SwitchScene(Scene2, "WelcomeScene.fxml");
    }

}
