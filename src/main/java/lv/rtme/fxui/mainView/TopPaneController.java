/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javax.annotation.PostConstruct;
import lv.rtme.ConfigurationControllers;
import lv.rtme.fxui.models.CodesOrderModel;
import lv.rtme.repositories.CodesOrdersRepository;
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
    
    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        Button one = new Button("",new Glyph("FontAwesome", FontAwesome.Glyph.COPY));
        one.resize(30, 30);
        one.setTooltip(new Tooltip("Создать новый на основе"));
        Button two = new Button("",new Glyph("FontAwesome", FontAwesome.Glyph.EDIT));
        two.resize(30, 30);
        
        buttonsHBox.getChildren().addAll(one,two);
        
        model.getFileIdProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                
                centerStackPane.getChildren().add(new Label(newValue));
            }
        });
        
        updateState();
        
        
        
    }

    private void updateState() {
        
        LocalDate date = LocalDate.now();
        
        
       dateText.setText(date.format(DateTimeFormatter.ISO_DATE));
       
       tottalLabel.setText(String.valueOf(repository.count()));
       
   int a=   repository.findByIsOrderedFalse().size();
   notOrderedLabel.setText(String.valueOf(a));
       
    }
    
}
