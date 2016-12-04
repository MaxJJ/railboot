/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.rightEditor;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.util.StringConverter;
import javax.annotation.PostConstruct;
import lv.rtme.entities.CodesOrders;
import lv.rtme.entities.Persons;
import lv.rtme.entities.Station;
import lv.rtme.fxui.UtilBeansCollection;
import lv.rtme.fxui.models.CodesOrderModel;
import lv.rtme.repositories.PersonsRepository;
import lv.rtme.repositories.StationRepository;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * FXML Controller class
 *
 * @author Maksims
 */
public class RightEditorController implements Initializable {

    @FXML
    private FlowPane rightFlowPane;
    @FXML
    private Button saveButton;
    @FXML
    private TextField fileField;
    @FXML
    private TextField tagsTextField;
    @FXML
    private TextField providerField;
    @FXML
    private TextField periodField;
    @FXML
    private TextField wagonField;
    @FXML
    private TextField weightField;
    @FXML
    private TextField containerField;
    @FXML
    private TextField tareField;
    @FXML
    private TextField payRoadsField;
    @FXML
    private TextField rateField;
    @FXML
    private TextField rateCurrencyField;
    @FXML
    private TextField securityRateField;
    @FXML
    private TextField securCurrencyField;
    @FXML
    private ComboBox<Station> stDispCombo;
    @FXML
    private ComboBox<Station> stDestCombo;
    @FXML
    private ComboBox<Persons> consiNameCombo;
    @FXML
    private TextArea consiArea;
    @FXML
    private Button addStationButton;
    @FXML
    private Button addConsigneeButton;
    @FXML
    private TextArea cargoArea;
     @Autowired
    UtilBeansCollection utils;
     @Autowired
    private PersonsRepository personsRepository;
     @Autowired
    private StationRepository stationRepository;
     private ObservableList<Station> stationsComboListist = FXCollections.observableArrayList();
  @Qualifier("coModel")
    @Autowired
    private CodesOrderModel model;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        
        setSaveButtonAction();
        
          stationsComboListist.addAll(stationRepository.findAll());
  stationsComboListist.addListener((ListChangeListener.Change<? extends Station> change) -> {
      stDestCombo.getItems().clear();
      stDestCombo.itemsProperty().setValue(stationsComboListist);
         });
  
        stDestCombo.itemsProperty().setValue(stationsComboListist);
        stDestCombo.converterProperty().setValue(getStationConverter());
        stDestCombo.setEditable(true);
        TextFields.bindAutoCompletion(stDestCombo.getEditor(), (AutoCompletionBinding.ISuggestionRequest param) -> {
            return stationRepository.findByStationNameLikeIgnoreCase("%" + param.getUserText() + "%");
        }, getStationConverter());
        TextFields.bindAutoCompletion(consiNameCombo.getEditor(), (AutoCompletionBinding.ISuggestionRequest param) -> {
            return personsRepository.findBySampleNameLike("%" + param.getUserText() + "%");
        }, getPersonsConverter());
        
        
        stDispCombo.itemsProperty().setValue(utils.strbean());
        stDispCombo.converterProperty().setValue(getStationConverter());
        
        consiNameCombo.converterProperty().setValue(getPersonsConverter());
        consiNameCombo.setEditable(true);
        ObservableList<String> list = FXCollections.observableArrayList();
        List<Persons> pl = personsRepository.findAllByOrderBySearchNameAsc();
        consiNameCombo.getItems().addAll(pl);

        consiNameCombo.valueProperty().addListener(new ChangeListener<Persons>() {
            @Override
            public void changed(ObservableValue<? extends Persons> observable, Persons oldValue, Persons newValue) {

                consiArea.setText(newValue.getSampleName());
            }
        });
    }
       private StringConverter<Station> getStationConverter(){
        
        return new StringConverter<Station>() {
            @Override
            public String toString(Station object) {
             String name = null;
                if(object!=null){
                name = object.getStationName();}
                else {name="pizdec!";}
                return name;
            }
            @Override
            public Station fromString(String string) {
                
                return stationRepository.findByStationName(string).get(0);
            }
        };
    }
    
    private StringConverter<Persons> getPersonsConverter(){
        
        return new StringConverter<Persons>() {
            @Override
            public String toString(Persons object) {
             String name = null;
                if(object!=null){
                name = object.getSearchName();}
                else {name="pizdec!";}
                return name;
            }
            @Override
            public Persons fromString(String string) {
                
                return personsRepository.findBySearchName(string).get(0);
            }
        };
    }
    
    public void setFields(){
//        fileField.setText(model.getCodesOrders().getFileID());
//        fileField.setEditable(false);
//        stDispCombo.setValue(model.getCodesOrders().getStationOfDispatch());
//        stDestCombo.setValue(model.getCodesOrders().getStationOfDestination());
//        consiNameCombo.setValue(model.getCodesOrders().getConsignee());
//        cargoArea.setText(model.getCodesOrders().getCargo());
//        containerField.setText(model.getCodesOrders().getUnit());
//        wagonField.setText(model.getCodesOrders().getWagon());
//        weightField.setText(model.getCodesOrders().getWeight());
//        rateField.setText(model.getCodesOrders().getRate());
//        rateCurrencyField.setText(model.getCodesOrders().getRateCurrency());
//        providerField.setText(model.getCodesOrders().getProvider());
//        payRoadsField.setText(model.getCodesOrders().getRoadsToPay());
//        weightField.setText(model.getCodesOrders().getWeight());
        
        fileField.textProperty().bindBidirectional(model.getFileIdProperty());
        fileField.setEditable(false);
        stDispCombo.valueProperty().bindBidirectional(model.getDispatchStationObjectProperty());
        stDestCombo.valueProperty().bindBidirectional(model.getDestinationStationObjectProperty());
        consiNameCombo.valueProperty().bindBidirectional(model.getConsigneeObjectProperty());
        cargoArea.textProperty().bindBidirectional(model.getCargoProperty());
        containerField.setText(model.getCodesOrders().getUnit());
        wagonField.setText(model.getCodesOrders().getWagon());
        weightField.setText(model.getCodesOrders().getWeight());
        rateField.setText(model.getCodesOrders().getRate());
        rateCurrencyField.setText(model.getCodesOrders().getRateCurrency());
        providerField.setText(model.getCodesOrders().getProvider());
        payRoadsField.setText(model.getCodesOrders().getRoadsToPay());
        weightField.setText(model.getCodesOrders().getWeight());
}

    private void setSaveButtonAction() {
        saveButton.setOnAction(event -> { 
       CodesOrders order = model.getCodesOrders();
        
    });
    }
   
}
