import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class MainPage {

    @FXML
    private Label HelloText;

    @FXML
    private AnchorPane MainAnchor;

    @FXML
    private Label TaskLabel;

    @FXML
    private ListView<?> myListView;

    @FXML
    void AddButton(ActionEvent event) throws IOException {
        new SwitchScene(MainAnchor, "AddController.fxml");
    }

}
