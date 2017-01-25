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
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javax.annotation.PostConstruct;
import lombok.Getter;
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
    @FXML @Getter
    private SplitPane splitPane;
    @FXML @Getter
    private AnchorPane topAnchor;
    @FXML @Getter
    private TextFlow fileTextFlow;
    @FXML @Getter
    private TextFlow stationsTextFlow;

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
        
       
    }
    
    
}
