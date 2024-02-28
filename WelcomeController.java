import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
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
    private Parent root;

    @FXML
    void LoginButton(ActionEvent event) throws IOException {
        String username = NameField.getText();
        String password = PasswordField.getText();

        if (checkDetails(username, password)) {
            System.out.println("Reusit");
            DataStore.getInstance().setUsername(username);
            System.out.println("Numele trimis este " + NameField.getText());

            new SwitchScene(Scene1, "MainPage.fxml");
        }

        else {
            System.out.println("Nereusit");
        }

    }

    @FXML
    void RegisterButton(ActionEvent event) throws IOException {
        new SwitchScene(Scene1, "RegisterScene.fxml");
    }

    private boolean checkDetails(String Name, String Password) {
        try {
            File file = new File("details.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                String storedUsername = parts[0];
                String storePassword = parts[1];

                if (storedUsername.equals(Name) && storePassword.equals(Password)) {
                    bufferedReader.close();
                    return true;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
