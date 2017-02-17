/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView.actions;

import java.util.List;
import javafx.scene.control.MenuButton;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import lv.rtme.entities.CodesOrders;
import lv.rtme.fxui.ApplicationViewsAndControllers;
import lv.rtme.fxui.controllers.MainEditorController;
import lv.rtme.fxui.controllers.RailbootMainController;
import lv.rtme.fxui.models.CodesOrdersProperties;
import lv.rtme.fxui.models.PageInfo;
import lv.rtme.repositories.CodesOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import lv.rtme.fxui.models.TableItemsProperty;

/**
 *
 * @author Maksims
 */

@Component
public class RailbootMainActions {
    
     @Autowired
    private RailbootMainController controller; 
     @Autowired
    private MainEditorController controllerMainEditor; 
     @Autowired
    private TableItemsProperty tableItemsProperty;
     
    @Autowired
    CodesOrdersRepository codesOrdersRepository;
     @Autowired
    CodesOrdersProperties codesOrdersProperties;
     @Autowired
     PageInfo page;
     
    @Qualifier("editor")
     @Autowired
     ApplicationViewsAndControllers.View editorView;

    public void whenCodesOrdersIsSelected() {
        CodesOrders selectedCo = controller.getCodesOrdersTable().getSelectionModel().getSelectedItem().getCo().getValue();
          codesOrdersProperties.setCodesOrders(selectedCo);
          activateFileButton();
    }

    public void activateFileButton() {
      MenuButton mb = controller.getFileMenuButton();
        mb.disableProperty().setValue(Boolean.FALSE);
       mb.setText("ФАЙЛ "+codesOrdersProperties.getCo().getValue().getFileID());
       
       
    }
    public void disactivateFileButton() {
      MenuButton mbx = controller.getFileMenuButton();
        mbx.disableProperty().setValue(Boolean.TRUE);
       
        mbx.setText(""); 
    }

    public void whenFileMenuButtonEditIsClicked() {
    switchToEditorView();
      
    }

    public void fillTableAll() {
       
        controller.getCodesOrdersTable().getItems().clear();
                List<CodesOrders> que = codesOrdersRepository.findAll();
                tableItemsProperty.setInList(que);
                controller.getCodesOrdersTable().setItems(tableItemsProperty.getItemsProperty().getValue());
    }
    public void fillTableNotOrdered() {
       
        controller.getCodesOrdersTable().getItems().clear();
                List<CodesOrders> que = codesOrdersRepository.findByIsOrderedFalse();
                tableItemsProperty.setInList(que);
                controller.getCodesOrdersTable().setItems(tableItemsProperty.getItemsProperty().getValue());
    }

    public void whenCreateButtonisClicked() {
        codesOrdersProperties.setCodesOrders(new CodesOrders());
        switchToEditorView();
     
       
    }
    
    private void switchToEditorView(){
          AnchorPane appAnchorPane = controller.getAppAnchorPane();
      SplitPane editor = controllerMainEditor.getSplitPane();
        appAnchorPane.getChildren().clear();
        appAnchorPane.getChildren().add(editorView.getView());
       appAnchorPane.setTopAnchor(editor, 0.0);
       appAnchorPane.setLeftAnchor(editor, 0.0);
       appAnchorPane.setRightAnchor(editor, 0.0);
       appAnchorPane.setBottomAnchor(editor, 0.0);
       
       page.init();
       page.fill();  
        
    }

 
    
    

    

    }



 
    
    
    
    

