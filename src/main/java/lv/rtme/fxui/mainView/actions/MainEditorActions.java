/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView.actions;

import javafx.scene.Node;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javax.annotation.PostConstruct;
import lv.rtme.entities.CodesOrders;
import lv.rtme.fxui.mainView.ApplicationViewsAndControllers;
import lv.rtme.fxui.mainView.MainEditorController;
import lv.rtme.fxui.models.CodesOrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */
@Component
public class MainEditorActions {
    
       @Qualifier("mainEditorView")
    @Autowired
    private ApplicationViewsAndControllers.View mainEditorView;
    
    private  MainEditorController mainEditorController;
    @Qualifier("coModel")
    @Autowired
    private CodesOrderModel model;
    
         @PostConstruct
    void setController(){
        
        mainEditorController= (MainEditorController) mainEditorView.getController();
    }

    public Node showEmpty() {
        
        return mainEditorView.getView();
    }
    
     public Node showFilledWith(CodesOrders codesOrders) {
        setEditorFields(codesOrders);
        return mainEditorView.getView();
    }

    private void setEditorFields(CodesOrders codesOrders) {
       
//       fileField().setText(codesOrders.getFileID());
       
       fileField().textProperty().bindBidirectional(model.getFileIdProperty());
       
               
               }

    private TextField fileField() {
        
        return mainEditorController.getFileField();
    }

    private MenuButton stDispMenuButton() {
        
        return mainEditorController.getStDispMenuButton();
    }
    
    
    
    
}
