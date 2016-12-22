/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView.actions;

import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.annotation.PostConstruct;
import lv.rtme.ConfigurationControllers;
import lv.rtme.entities.CodesOrders;
import lv.rtme.fxui.mainView.RailbootMainController;
import lv.rtme.fxui.models.CodesOrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */

@Component
public class RailbootMainActions {
    
      @Qualifier("railbootMainView")
    @Autowired
    private ConfigurationControllers.View  railbootMainView;
    
    private RailbootMainController railbootMainController; 
           
    
    @Qualifier("coModel")
    @Autowired
    private CodesOrderModel model;
    
    @Autowired
    TopPaneActions topPaneActions;

 
    
    @PostConstruct
    void setController(){
        
        railbootMainController=(RailbootMainController) railbootMainView.getController();
    }
    

    
    public void initialSetting() {
        
       codesOrdersTable().setOnMousePressed((MouseEvent event) -> {
        if (event.isPrimaryButtonDown() && event.getClickCount() == 1) {
            
           CodesOrders coCheck =  codesOrdersTable().getSelectionModel().getSelectedItem().getCodesOrders();
           if(coCheck !=null && !coCheck.getFileID().isEmpty()){
            model.init(coCheck);

topPaneActions.showInfo();
           }
        }
        });
    
    codesOrdersTable().setOnKeyPressed((KeyEvent event) -> {
        if (event.getCode()==KeyCode.ENTER || event.getCode()==KeyCode.SPACE) {
            
           CodesOrders coCheck =  codesOrdersTable().getSelectionModel().getSelectedItem().getCodesOrders();
           if(coCheck !=null && !coCheck.getFileID().isEmpty()){
            model.init(coCheck);
         topPaneActions.showInfo();
           }
        }
        });  
    }

    private TableView<CodesOrderModel> codesOrdersTable() {
        return railbootMainController.getCodesOrdersTable();
    }
    
    
    
    
}
