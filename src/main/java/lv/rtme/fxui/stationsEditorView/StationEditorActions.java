/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.stationsEditorView;

import lv.rtme.ConfigurationControllers;
import org.controlsfx.control.action.ActionProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author Maksims
 */
public class StationEditorActions {
   @Qualifier("stationsEditor") 
   @Autowired
    private ConfigurationControllers.View stationsEditorView;

    public StationEditorActions() {
        
     
    }
   
    
   @ActionProxy(text = "controls text",accelerator = "ctrl+shift+R")
   private void action11() {
         System.out.println( "controls text is executed");
         System.out.println( stationsEditorView);
     }

 
    
    
}
