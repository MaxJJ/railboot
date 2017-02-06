/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView.settings;

import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.StringConverter;
import lv.rtme.entities.Station;
import lv.rtme.fxui.controllers.MainEditorController;
import lv.rtme.fxui.controllers.RailbootMainController;
import lv.rtme.fxui.mainView.actions.MainEditorActions;
import lv.rtme.fxui.models.CodesOrdersProperties;
import lv.rtme.fxui.models.TableItemsProperty;
import lv.rtme.repositories.CodesOrdersRepository;
import lv.rtme.repositories.StationRepository;
import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.TextFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */
@Component
public class MainEditorSettings {

    @Autowired
    private MainEditorController controller;
    @Autowired
    RailbootMainController homeController;
   
    @Autowired
    CodesOrdersRepository codesOrdersRepository;
    
    @Autowired
    CodesOrdersProperties codesOrdersProperties;
    @Autowired
    TableItemsProperty tableItemsProperty;
    @Autowired
    MainEditorActions act;
    @Autowired
    StationsEditorSettings setStationsEditors;
    @Autowired
    FileEditorSettings setFileEditors;
    @Autowired
    ConsigneeEditorSettings setConsigneeEditors;

    public void homeButton() {
        
     Button home=   controller.getHomeButton();
     home.setOnAction((eh)->{
         
//         CodesOrders x=new CodesOrders();
//        codesOrdersProperties.setCodesOrders(x);
        homeController.getAppAnchorPane().getChildren().clear();
        homeController.getAppAnchorPane().getChildren().add(homeController.getTableVbox());
        
     });
       
    }

    public void editorsFieldsBindings() {
       
        controller.getFileEditorFileIdTextField().textProperty().bindBidirectional(codesOrdersProperties.getFileIdProperty());
        controller.getFileEditorDescriptionTextArea().textProperty().bindBidirectional(codesOrdersProperties.getCustomTagProperty());
        controller.getStationsEditorStDispHLink().textProperty().bindBidirectional(codesOrdersProperties.getStationOfDispatchProperty());
        controller.getStationsEditorStDestHLink().textProperty().bindBidirectional(codesOrdersProperties.getStationOfDestinationProperty());
        controller.getConsigneeEditorTextArea().textProperty().bindBidirectional(codesOrdersProperties.getConsigneeProperty());
        
    }

    public void navigation() {
       controller.getFileHLink().setOnAction((eh)->{act.whenFileLinkClicked();});
       controller.getStationsHLink().setOnAction((eh)->{act.whenStationLinkClicked();});
       controller.getConsigneeHLink().setOnAction((eh)->{act.whenConsigneeLinkClicked();});
        
    }

    public void editors() {
  
     setStationsEditors.editor();
     setConsigneeEditors.editor();
    }

    private void setStationsEditor() {
        
        
    }

   

   

   
    

    

    
}
