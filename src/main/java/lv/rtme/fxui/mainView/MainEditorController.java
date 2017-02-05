/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;
import javax.annotation.PostConstruct;
import lombok.Getter;
import lv.rtme.entities.Station;
import lv.rtme.fxui.mainView.settings.MainEditorSettings;
import lv.rtme.fxui.models.CodesOrdersProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * FXML Controller class
 *
 * @author Maksims
 */
public class MainEditorController implements Initializable {

    
       @Autowired
    CodesOrdersProperties codesOrdersProperties;
        @Autowired
    MainEditorSettings set;
        
        
    @FXML @Getter
    private SplitPane splitPane;
    @FXML @Getter
    private AnchorPane topAnchor;
    @FXML @Getter
    private TextFlow fileTextFlow;
    @FXML @Getter
    private TextFlow stationsTextFlow;
    @FXML @Getter
    private TextFlow consigneeTextFlow;
    @FXML @Getter
    private TextFlow transportTextFlow;
    @FXML @Getter
    private TextFlow paymentsTextFlow;
    @FXML @Getter
    private TextFlow cargoTextFlow;
    @FXML @Getter
    private Button homeButton;
    @FXML @Getter
    private ScrollPane page;
    @FXML @Getter
    private Hyperlink fileHLink;
    @FXML @Getter
    private Hyperlink stationsHLink;
    @FXML @Getter
    private StackPane editorsStackPane;
    @FXML @Getter
    private VBox fileEditorVBox;
    @FXML @Getter
    private TextField fileEditorFileIdTextField;
    @FXML @Getter
    private TextArea fileEditorDescriptionTextArea;
    @FXML @Getter
    private VBox stationsEditorVBox;
    @FXML @Getter
    private Hyperlink stationsEditorStDispHLink;
    @FXML @Getter
    private Hyperlink stationsEditorStDestHLink;
    @FXML @Getter
    private TextField stationsEditorSearchTextField;
    @FXML @Getter
    private Button stationsEditorSaveButton;
    @FXML @Getter
    private ListView<Station> stationsEditorListView;
    @FXML @Getter
    private Hyperlink infoPageFileHLink;
    @FXML @Getter
    private Hyperlink infoPageStationsHLink;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

     @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        
       set.homeButton();
       set.navigation();
       set.editorsFieldsBindings();
       set.editors();
       
    }
    
    
}
