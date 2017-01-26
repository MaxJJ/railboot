/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView.actions;

import javafx.scene.Node;
import javax.annotation.PostConstruct;
import lv.rtme.fxui.mainView.ApplicationViewsAndControllers;
import lv.rtme.fxui.mainView.MainEditorController;
import lv.rtme.fxui.mainView.settings.MainEditorSettings;
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
       
    @Autowired
    private  MainEditorController controller;
   
    
    @Autowired
    MainEditorSettings set;
    

    public Node showEmpty() {
        
        return mainEditorView.getView();
    }
    


    
    
    
    
}
