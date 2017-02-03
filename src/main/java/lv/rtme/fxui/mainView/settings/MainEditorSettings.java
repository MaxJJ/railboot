/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView.settings;

import java.util.List;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lv.rtme.entities.CodesOrders;
import lv.rtme.fxui.mainView.MainEditorController;
import lv.rtme.fxui.mainView.RailbootMainController;
import lv.rtme.fxui.mainView.actions.MainEditorActions;
import lv.rtme.fxui.mainView.actions.RailbootMainActions;
import lv.rtme.fxui.models.CodesOrdersProperties;
import lv.rtme.fxui.models.TableItemsProperty;
import lv.rtme.repositories.CodesOrdersRepository;
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
        
    }
    

    

    
}
