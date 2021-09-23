package scripts.gui;

import com.allatori.annotations.DoNotRename;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@DoNotRename
public class GUIController extends AbstractGUIController {

    @FXML
    private Button btnAddMonitor;

    @FXML
    private Button btnStart;

    @FXML
    private ComboBox<?> cmbProfile;

    @FXML
    private ComboBox<?> cmbType;

    @FXML
    private ListView<String> listMonitors;

    @FXML
    private TextField txtInput;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtOutput;

    @FXML
    private TextField txtThreshold;

    @FXML
    private TextField txtUrl;

    @FXML
    void addMonitorPressed(ActionEvent event) {

    }

    @FXML
    void startPressed(ActionEvent event) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }


}
