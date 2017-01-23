/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javax.annotation.PostConstruct;
import lv.rtme.ConfigurationControllers;
import lv.rtme.fxui.mainView.actions.TopPaneActions;
import lv.rtme.fxui.models.CodesOrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author Maksims
 */
public class TopPaneController {
     @Qualifier("coModel")
    @Autowired
    private CodesOrderModel model;
     
     @Qualifier("stationsEditor")
    @Autowired
    private ConfigurationControllers.View stationsEditorView;
     @Qualifier("railbootMainView")
    @Autowired
    private ConfigurationControllers.View mainView; 
       
     
     
   
      
      @Autowired
      private TopPaneActions actions;

    @FXML
    private HBox topCenterHBox;
    @FXML
    private Label tottalLabel;
    @FXML
    private Label notOrderedLabel;
    @FXML
    private Label notRequestedLabel;
    
    @FXML
    private Text dateText;
    
    @FXML
    private StackPane centerStackPane;
    @FXML
    private Text infoText;
    
    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        actions.updateState();
    }


    
  

    public Text getDateText() {
        return dateText;
    }

    public Label getTottalLabel() {
        return tottalLabel;
    }

    public Label getNotOrderedLabel() {
        return notOrderedLabel;
    }

    public Label getNotRequestedLabel() {
        return notRequestedLabel;
    }

    public StackPane getCenterStackPane() {
        return centerStackPane;
    }
    
    
}
