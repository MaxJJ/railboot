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
import javax.annotation.PostConstruct;
import lombok.Getter;

/**
 * FXML Controller class
 *
 * @author Maksims
 */
public class MainEditorController implements Initializable {

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

     @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        
    }
    
    
}
