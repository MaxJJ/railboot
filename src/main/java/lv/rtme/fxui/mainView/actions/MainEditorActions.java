/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView.actions;

import lv.rtme.fxui.controllers.MainEditorController;
import lv.rtme.fxui.mainView.settings.MainEditorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */
@Component
public class MainEditorActions {
    
  
       
    @Autowired
    private  MainEditorController controller;
   
    
    @Autowired
    MainEditorSettings set;
    

    public void whenFileLinkClicked() {
        
        setAllInvisible();
        controller.getFileEditorVBox().setVisible(true);
        
    }

    public void whenStationLinkClicked() {
         setAllInvisible();
        controller.getStationsEditorVBox().setVisible(true);
    }

    public void whenConsigneeLinkClicked() {
        setAllInvisible();
        controller.getConsigneeEditorVBox().setVisible(true);
    }
    
    public void whenTransportLinkClicked() {
       setAllInvisible();
        controller.getTransportEditorVBox().setVisible(true);
        
    }
    
    
    private void setAllInvisible() {
       
        controller.getFileEditorVBox().setVisible(false);
        controller.getStationsEditorVBox().setVisible(false);
        controller.getConsigneeEditorVBox().setVisible(false);
        controller.getTransportEditorVBox().setVisible(false);
    }


    


    
    
    
    
}
