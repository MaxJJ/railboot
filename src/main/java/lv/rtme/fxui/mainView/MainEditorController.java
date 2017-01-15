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
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import lombok.Getter;

/**
 * FXML Controller class
 *
 * @author Maksims
 */
public class MainEditorController implements Initializable {

    @FXML @Getter
    private FlowPane rightFlowPane;
    @FXML @Getter
    private HBox toolHboxCoEditor;
    @FXML @Getter
    private Button saveButton;
    @FXML @Getter
    private TextField fileField;
    
    @FXML @Getter
    private TextField wagonField;
    @FXML @Getter
    private TextField weightField;
    @FXML @Getter
    private TextField containerField;
    @FXML @Getter
    private TextField tareField;
    
    @FXML @Getter
    private MenuButton stDispMenuButton;
    @FXML @Getter
    private MenuItem stDispChange;
    @FXML @Getter
    private MenuButton stDestMenuButton;
    @FXML @Getter
    private MenuItem stDiestChange;
    @FXML @Getter
    private MenuButton consigneeMenuButton;
    @FXML @Getter
    private MenuItem consigneeChange;
    @FXML @Getter
    private TextArea consigneeTextArea;
    @FXML @Getter
    private TextArea cargoTextArea;
    @FXML @Getter
    private TextArea descriptionTextArea;
    @FXML @Getter
    private CheckBox isContainerised;
    @FXML @Getter
    private MenuButton paymentsMenuButton;
    @FXML @Getter
    private MenuItem paymentsChange;
    @FXML @Getter
    private TextArea paymentsTextArea;
    @FXML @Getter
    private SplitPane splitPane;
    @FXML @Getter
    private AnchorPane topAnchor;
    @FXML @Getter
    private AnchorPane bottomAnchor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
    
}
