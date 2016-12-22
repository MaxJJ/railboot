/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javax.annotation.PostConstruct;

/**
 *
 * @author Maksims
 */
public class SelectedItemTopPaneController {

    @FXML
    private VBox recordInfoVBox;
    @FXML
    private HBox firstHBox;
    @FXML
    private Label idLabel;
    @FXML
    private Label tagLabel;
    @FXML
    private Label stDispLabel;
    @FXML
    private Label stDestLabel;
    @FXML
    private Label providerLabel;
    @FXML
    private Label roadsLabel;
    @FXML
    private Label wagonLabel;
    @FXML
    private Label containerLabel;
    @FXML
    private HBox buttonsHBox;
    @FXML
    private Label grossWeightLabel;
    @FXML
    private Label lashingLabel;
    @FXML
    private Label tareLabel;
    @FXML
    private Label rateLabel;
    @FXML
    private Label guardRateLabel;
    
    
 public void initialize() {  }
   
   
    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
    }

    public VBox getRecordInfoVBox() {
        return recordInfoVBox;
    }

    public HBox getFirstHBox() {
        return firstHBox;
    }

    public Label getIdLabel() {
        return idLabel;
    }

    public Label getTagLabel() {
        return tagLabel;
    }

    public Label getStDispLabel() {
        return stDispLabel;
    }

    public Label getStDestLabel() {
        return stDestLabel;
    }

    public Label getProviderLabel() {
        return providerLabel;
    }

    public Label getRoadsLabel() {
        return roadsLabel;
    }

    public Label getWagonLabel() {
        return wagonLabel;
    }

    public Label getContainerLabel() {
        return containerLabel;
    }

    public HBox getButtonsHBox() {
        return buttonsHBox;
    }

    public Label getGrossWeightLabel() {
        return grossWeightLabel;
    }

    public Label getLashingLabel() {
        return lashingLabel;
    }

    public Label getTareLabel() {
        return tareLabel;
    }

    public Label getRateLabel() {
        return rateLabel;
    }

    public Label getGuardRateLabel() {
        return guardRateLabel;
    }
    

    
    
}
