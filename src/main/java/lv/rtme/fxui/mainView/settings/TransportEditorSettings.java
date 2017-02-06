/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView.settings;

import lv.rtme.fxui.controllers.MainEditorController;
import lv.rtme.fxui.models.CodesOrdersProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component
public class TransportEditorSettings {
   
     @Autowired
    private MainEditorController controller;
      @Autowired
    CodesOrdersProperties codesOrdersProperties;
    
    public void editor() {
        
    }
    

}
