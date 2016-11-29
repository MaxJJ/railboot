/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.rightEditor;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import lv.rtme.entities.Persons;
import lv.rtme.entities.Station;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
// @SuppressWarnings("unchecked")
//    @PostConstruct
//   public void init(){
//          /* setting combos with station     */
//        stationsComboListist.addAll(stationRepository.findAll());
//  stationsComboListist.addListener((ListChangeListener.Change<? extends Station> change) -> {
//      stDestCombo.getItems().clear();
//      stDestCombo.itemsProperty().setValue(stationsComboListist);
//         });
//  
//        stDestCombo.itemsProperty().setValue(stationsComboListist);
//        stDestCombo.converterProperty().setValue(getStationConverter());
//        stDestCombo.setEditable(true);
//        TextFields.bindAutoCompletion(stDestCombo.getEditor(), (AutoCompletionBinding.ISuggestionRequest param) -> {
//            return stationRepository.findByStationNameLikeIgnoreCase("%" + param.getUserText() + "%");
//        }, getStationConverter());
//        TextFields.bindAutoCompletion(consiNameCombo.getEditor(), (AutoCompletionBinding.ISuggestionRequest param) -> {
//            return personsRepository.findBySampleNameLike("%" + param.getUserText() + "%");
//        }, getPersonsConverter());
//        
//        
//        stDispCombo.itemsProperty().setValue(utils.strbean());
//        stDispCombo.converterProperty().setValue(getStationConverter());
//        
//        consiNameCombo.converterProperty().setValue(getPersonsConverter());
//        consiNameCombo.setEditable(true);
//        ObservableList<String> list = FXCollections.observableArrayList();
//        List<Persons> pl = personsRepository.findAllByOrderBySearchNameAsc();
//        consiNameCombo.getItems().addAll(pl);
//
//        consiNameCombo.valueProperty().addListener(new ChangeListener<Persons>() {
//            @Override
//            public void changed(ObservableValue<? extends Persons> observable, Persons oldValue, Persons newValue) {
//
//                consiArea.setText(newValue.getSampleName());
//            }
//        }); 
//        
//    }
//    
//    
//    
//    @FXML
//    private void addItem() {
//        CodesOrders co= model.getCodesOrders();
//   
//   co.setFileID(fileField.getText()); 
//   co.setStationOfDispatch(stDispCombo.getValue());
//   co.setStationOfDestination(stDestCombo.getValue());
//   co.setCargo(cargoArea.getText());
//   
//repository.save(co);
//CodesOrders comod = repository.findOne(co.getId());
//model.init(comod);
//codesOrdersTable.getItems().get(row.getIndex()).init(comod);
//    }
//
//    @FXML
//    private void stationsEditor(ActionEvent event) {
//         openModal(stationsEditorView.getView());
//    }
    
}
