import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class WelcomeController {

    @FXML
    private Button LoginButton;

    @FXML
    private TextField NameField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button RegisterButton;

    @FXML
    private AnchorPane Scene1;

    @FXML
    private Label WelcomeText;

    @FXML
    void LoginButton(ActionEvent event) {

    }

    @FXML
    void RegisterButton(ActionEvent event) throws IOException {
        new SwitchScene(Scene1, "RegisterScene.fxml");
    }

}
