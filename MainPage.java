
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private ListView<String> myListView;
    private String username = DataStore.getInstance().getUsername();
    private String nume = "Task_" + username + ".txt";
    private String fString;

    public List<String> lista(String numeFisier) throws FileNotFoundException, IOException {

        List<String> listaSir = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nume))) {
            String linie;
            int cnt = 0;
            while ((linie = br.readLine()) != null) {
                if (cnt % 4 == 0) {
                    listaSir.add(linie);
                }
                cnt++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaSir;
    }

    public void initialize() {
        try {
            myListView.getItems().addAll(lista(nume));
            myListView.getSelectionModel().selectedItemProperty().addListener((new ChangeListener<String>() {

                @Override
                public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                    fString = myListView.getSelectionModel().getSelectedItem();
                    try (BufferedReader br = new BufferedReader(new FileReader(nume))) {
                        String linie;
                        boolean readDetails = false;
                        while ((linie = br.readLine()) != null) {
                            if (readDetails) {
                                if (linie.equals("~")) {
                                    break;
                                }
                                fString += "\n" + linie;
                            }
                            if (linie.equals(fString)) {
                                readDetails = true;
                            }

                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    TaskLabel.setText(fString);
                }

            }));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void AddButton(ActionEvent event) throws IOException {
        new SwitchScene(MainAnchor, "AddController.fxml");
    }
}
