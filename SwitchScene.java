import java.io.IOException;
import java.util.Objects;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class SwitchScene {
    public SwitchScene(AnchorPane currentAnchorPane, String fxml) throws IOException {
        AnchorPane nextAnchorPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        currentAnchorPane.getChildren().setAll(nextAnchorPane);
    }
}
