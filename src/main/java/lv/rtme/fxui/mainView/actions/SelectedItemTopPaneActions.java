/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView.actions;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javax.annotation.PostConstruct;
import lv.rtme.fxui.mainView.ApplicationViewsAndControllers;
import lv.rtme.fxui.mainView.SelectedItemTopPaneController;
import lv.rtme.fxui.models.CodesOrderModel;
import org.controlsfx.control.PopOver;
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
public class SelectedItemTopPaneActions {
    
    @Qualifier("topPaneSelectedItemView")
    @Autowired
    private ApplicationViewsAndControllers.View  selectedItemView;
    
    private SelectedItemTopPaneController selectedItemTopPaneController;
            
    
     @Qualifier("coModel")
    @Autowired
    private CodesOrderModel model;
     
     
       @PostConstruct
    void setController(){
        
        selectedItemTopPaneController=(SelectedItemTopPaneController) selectedItemView.getController();
    }
    
      public void setInfo(){
     recordInfoVBox().setVisible(true);
        firstHBox().setVisible(true);
      
        idLabel().setText(model.getCodesOrders().getFileID());
        tagLabel().setText(model.getCodesOrders().getCustomTag());
//        stDispLabel.setText(model.getCodesOrders().getStationOfDispatch().getStationName());

        stDispLabel().textProperty().bind(model.getStationOfDispatchProperty());
        stDispLabel().setGraphic(new Glyph("FontAwesome", FontAwesome.Glyph.SIGN_OUT));
        stDestLabel().setText(model.getCodesOrders().getStationOfDestination().getStationName());
        stDestLabel().setGraphic(new Glyph("FontAwesome", FontAwesome.Glyph.SIGN_IN));
        
        providerLabel().setText(model.getCodesOrders().getProvider());
        roadsLabel().setText(model.getCodesOrders().getRoadsToPay());
       roadsLabel().setGraphic(new Glyph("FontAwesome",FontAwesome.Glyph.TRAIN));
       
       
       
       tagLabel().onMouseEnteredProperty().set(new EventHandler<MouseEvent>() {
           PopOver po=new PopOver(new TextArea(model.getCargoProperty().getValueSafe()));
           Label label = tagLabel();
         @Override
         public void handle(MouseEvent event) {
             po.show(label);
         }
     });
       
//            Button one = new Button("",new Glyph("FontAwesome", FontAwesome.Glyph.COPY));
//        one.resize(30, 30);
//        one.setTooltip(new Tooltip("Создать новый на основе"));
//        Button two = new Button("",new Glyph("FontAwesome", FontAwesome.Glyph.EDIT));
//        two.resize(30, 30);
//        two.setOnAction(new EventHandler<ActionEvent>() {
//            RailbootMainController mainCtrl = (RailbootMainController) mainView.getController();
//            RightEditorController rightCtrl = (RightEditorController) rightEditorView.getController();
//            @Override
//            public void handle(ActionEvent event) {
//                rightCtrl.setFields();
//             mainCtrl.getHomeTabStackPane().getChildren().clear();
//             mainCtrl.getHomeTabStackPane().getChildren().add(rightEditorView.getView());
//                            
//            }
//        });
//        buttonsHBox.getChildren().clear();
//        buttonsHBox.getChildren().addAll(one,two);
        
    }

   public Parent getSelectedItemView() {
        setInfo();
       return selectedItemView.getView();
        
    }

    private VBox recordInfoVBox() {
        
        return selectedItemTopPaneController.getRecordInfoVBox();
    }

    private HBox firstHBox() {
       return selectedItemTopPaneController.getFirstHBox();
    }

    private Label idLabel() {
       return  selectedItemTopPaneController.getIdLabel();
    }

    private Label tagLabel() {
       
        return  selectedItemTopPaneController.getTagLabel();
    }

    private Label stDispLabel() {
       return  selectedItemTopPaneController.getStDispLabel();
    }

    private Label stDestLabel() {
       return  selectedItemTopPaneController.getStDestLabel();
    }

    private Label providerLabel() {
       return  selectedItemTopPaneController.getProviderLabel();
    }

    private Label roadsLabel() {
       return  selectedItemTopPaneController.getRoadsLabel();
    }
    
}
