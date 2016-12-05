/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javax.annotation.PostConstruct;
import lv.rtme.ConfigurationControllers;
import lv.rtme.fxui.models.CodesOrderModel;
import lv.rtme.fxui.rightEditor.RightEditorController;
import lv.rtme.repositories.CodesOrdersRepository;
import org.controlsfx.control.PopOver;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.Glyph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author Maksims
 */
public class TopPaneController {
     @Qualifier("coModel")
    @Autowired
    private CodesOrderModel model;
     
     @Qualifier("stationsEditor")
    @Autowired
    private ConfigurationControllers.View stationsEditorView;
     @Qualifier("rightEditor")
    @Autowired
    private ConfigurationControllers.View rightEditorView; 
     @Qualifier("railbootMainView")
    @Autowired
    private ConfigurationControllers.View mainView; 
       
     
     
      @Autowired
    private CodesOrdersRepository repository;

    @FXML
    private HBox topCenterHBox;
    @FXML
    private Label tottalLabel;
    @FXML
    private Label notOrderedLabel;
    @FXML
    private Label notRequestedLabel;
    
    @FXML
    private Text dateText;
    @FXML
    private HBox buttonsHBox;
    @FXML
    private StackPane centerStackPane;
    @FXML
    private VBox recordInfoVBox;
    @FXML
    private Label idLabel;
    @FXML
    private Label tagLabel;
    @FXML
    private HBox firstHBox;
    @FXML
    private Label stDispLabel;
    @FXML
    private Label stDestLabel;
    @FXML
    private Label providerLabel;
    @FXML
    private Label roadsLabel;
    
    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        updateState();
    }

    public void updateState() {
        LocalDate date = LocalDate.now();
       dateText.setText(date.format(DateTimeFormatter.ISO_DATE));
       tottalLabel.setText(String.valueOf(repository.count()));
   int a=   repository.findByIsOrderedFalse().size();
   notOrderedLabel.setText(String.valueOf(a));
    }
    
    public void getRecordInfo(){
     recordInfoVBox.setVisible(true);
        firstHBox.setVisible(true);
      
        idLabel.setText(model.getCodesOrders().getFileID());
        tagLabel.setText(model.getCodesOrders().getCustomTag());
//        stDispLabel.setText(model.getCodesOrders().getStationOfDispatch().getStationName());

        stDispLabel.textProperty().bind(model.getStationOfDispatchProperty());
        stDispLabel.setGraphic(new Glyph("FontAwesome", FontAwesome.Glyph.SIGN_OUT));
        stDestLabel.setText(model.getCodesOrders().getStationOfDestination().getStationName());
        stDestLabel.setGraphic(new Glyph("FontAwesome", FontAwesome.Glyph.SIGN_IN));
        
        providerLabel.setText(model.getCodesOrders().getProvider());
        roadsLabel.setText(model.getCodesOrders().getRoadsToPay());
       roadsLabel.setGraphic(new Glyph("FontAwesome",FontAwesome.Glyph.TRAIN));
       
       
       
       tagLabel.onMouseEnteredProperty().set(new EventHandler<MouseEvent>() {
           PopOver po=new PopOver(new TextArea(model.getCargoProperty().getValueSafe()));
         @Override
         public void handle(MouseEvent event) {
             po.show(tagLabel);
         }
     });
       
            Button one = new Button("",new Glyph("FontAwesome", FontAwesome.Glyph.COPY));
        one.resize(30, 30);
        one.setTooltip(new Tooltip("Создать новый на основе"));
        Button two = new Button("",new Glyph("FontAwesome", FontAwesome.Glyph.EDIT));
        two.resize(30, 30);
        two.setOnAction(new EventHandler<ActionEvent>() {
            RailbootMainController mainCtrl = (RailbootMainController) mainView.getController();
            RightEditorController rightCtrl = (RightEditorController) rightEditorView.getController();
            @Override
            public void handle(ActionEvent event) {
                rightCtrl.setFields();
             mainCtrl.getHomeTabStackPane().getChildren().clear();
             mainCtrl.getHomeTabStackPane().getChildren().add(rightEditorView.getView());
                            
            }
        });
        buttonsHBox.getChildren().clear();
        buttonsHBox.getChildren().addAll(one,two);
        
    }
    
    
}
