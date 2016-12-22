/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView.actions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javax.annotation.PostConstruct;
import lv.rtme.fxui.mainView.ApplicationViewsAndControllers;
import lv.rtme.fxui.mainView.TopPaneController;
import lv.rtme.repositories.CodesOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */

@Component
public class TopPaneActions {
    
    @Qualifier("topPaneView")
    @Autowired
    private ApplicationViewsAndControllers.View topPaneView;
    
    private  TopPaneController topPaneController;
    
       @Autowired
    private CodesOrdersRepository codesOrdersRepository;
       @Autowired
       SelectedItemTopPaneActions selectedItemTopPaneActions;

    public TopPaneActions() {
    }
       
       
        @PostConstruct
    void setController(){
        
        topPaneController=(TopPaneController) topPaneView.getController();
    }
    
        public void updateState() {
        LocalDate date = LocalDate.now();
       dateText().setText(date.format(DateTimeFormatter.ISO_DATE));
       totalLabel().setText(String.valueOf(codesOrdersRepository.count()));
   int a=   codesOrdersRepository.findByIsOrderedFalse().size();
   notOrderedLabel().setText(String.valueOf(a));
    }

   public void showInfo() {
   Parent infoView = selectedItemTopPaneActions.getSelectedItemView();
       topPaneController.getCenterStackPane().getChildren().clear();
       topPaneController.getCenterStackPane().getChildren().add(infoView);
    }
   
   
    private Text dateText() {
       return topPaneController.getDateText();
    }

    private Label totalLabel() {
        return  topPaneController.getTottalLabel();
    }

    private Label notOrderedLabel() {
        return topPaneController.getNotOrderedLabel();
    }

    
    
    
    
}
