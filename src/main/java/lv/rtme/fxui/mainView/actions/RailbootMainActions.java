/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView.actions;

import javafx.scene.control.MenuButton;
import lv.rtme.entities.CodesOrders;
import lv.rtme.fxui.mainView.ApplicationViewsAndControllers;
import lv.rtme.fxui.mainView.MainEditorController;
import lv.rtme.fxui.mainView.RailbootMainController;
import lv.rtme.fxui.models.CodesOrdersProperties;
import lv.rtme.repositories.CodesOrdersRepository;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.Glyph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

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
    CodesOrdersRepository codesOrdersRepository;
     @Autowired
    CodesOrdersProperties codesOrdersProperties;
     
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
        mb.setGraphic(new Glyph("FontAwesome", FontAwesome.Glyph.EDIT));
        mb.textProperty().setValue("ФАЙЛ "+codesOrdersProperties.getCo().getValue().getFileID()); 
    }

    public void whenFileMenuButtonEditIsClicked() {
      
        controller.getAppAnchorPane().getChildren().clear();
        controller.getAppAnchorPane().getChildren().add(editorView.getView());
    }

 
    
    

    

    }



 
    
    
    
    

