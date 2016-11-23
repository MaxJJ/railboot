/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui;

import java.util.List;
import java.util.stream.Collector;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextFlow;
import javax.annotation.PostConstruct;
import lv.rtme.entities.Station;
import lv.rtme.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Maksims
 */

@SuppressWarnings("SpringJavaAutowiringInspection")
public class StationsEditorController {
    
        @FXML
    private AnchorPane stationsEditorsRoot;

    @FXML  private TextField stEditorSearchTextField;
    @FXML  private Button stEditorNewButton;
    @FXML  private TableView<StationsEditorModel> stEditorTableView;
    @FXML  private TableColumn<StationsEditorModel, String> nameColumn;
    @FXML  private TableColumn<StationsEditorModel, String> codeColumn;
    @FXML  private TableColumn<StationsEditorModel, String> roadColumn;
    @FXML  private TableColumn<StationsEditorModel, String> paragraphColumn;
    @FXML  private TextField nameTextField;
    @FXML  private TextField codeTextField;
    @FXML  private TextField roadTextField;
    @FXML  private TextField paragraphTextField;
    @FXML  private CheckBox isStationOfDispatch;
    @FXML  private CheckBox isExportStation;
    @FXML  private CheckBox isInStation;
    @FXML  private CheckBox isOutStation;
    @FXML  private TextFlow textFlow;
    @FXML  private Button saveButton;
       
    //-------------------------------
    
    @Autowired
    private StationRepository repository;
    
    private Station stationModel;
    
    @FXML    public void initialize() {  }
    
     @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
      
        nameColumn.setCellValueFactory((TableColumn.CellDataFeatures<StationsEditorModel, String> param) -> param.getValue().stationNameProperty);
        codeColumn.setCellValueFactory((TableColumn.CellDataFeatures<StationsEditorModel, String> param) -> param.getValue().stationCodeProperty);
        roadColumn.setCellValueFactory((TableColumn.CellDataFeatures<StationsEditorModel, String> param) -> param.getValue().stationRoadProperty);
        paragraphColumn.setCellValueFactory((TableColumn.CellDataFeatures<StationsEditorModel, String> param) -> param.getValue().stationParagraphProperty);
        
        stEditorTableView.setItems(getModels(repository.findAll()));
        
        stEditorTableView.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends StationsEditorModel> ov, StationsEditorModel t, StationsEditorModel t1) -> {
            stationModel = t1.station;
            setFields(stationModel);
          });  
            stEditorNewButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                  stationModel = new Station();
                    setFields(stationModel);
                }
            });
            saveButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                 
                stationModel.setStationName(nameTextField.getText());    
                stationModel.setStationCode(codeTextField.getText());    
                stationModel.setStationRoad(roadTextField.getText());    
                stationModel.setStationParagraph(paragraphTextField.getText());
                stationModel.setIsDispatch(isStationOfDispatch.isSelected());
                stationModel.setIsExport(isExportStation.isSelected());
                stationModel.setIsIn(isInStation.isSelected());
                stationModel.setIsOut(isOutStation.isSelected());
    
    repository.save(stationModel);
    
    int ind = stEditorTableView.getSelectionModel().getSelectedIndex();
    stEditorTableView.getItems().set(ind, new StationsEditorModel(repository.findByStationName(stationModel.getStationName()).get(0)) );
                }
            });
            
        
    }
    
    public ObservableList<StationsEditorModel> getModels(List<Station> stationList){
       ObservableList<StationsEditorModel> list = FXCollections.observableArrayList();
     
        for (Station station : stationList) {
          
            StationsEditorModel stedmod = new StationsEditorModel(station);
            list.add(stedmod);
        }
        
        
        return list;
    }

    private void setFields(Station stMod) {
        
    nameTextField.setText(stMod.getStationName());
    codeTextField.setText(stMod.getStationCode());
    roadTextField.setText(stMod.getStationRoad());
    paragraphTextField.setText(stMod.getStationParagraph());
    isStationOfDispatch.setSelected(stMod.isIsDispatch());
    isExportStation.setSelected(stMod.isIsExport());
    isInStation.setSelected(stMod.isIsIn());
    isOutStation.setSelected(stMod.isIsOut());
    
        
        
    }
    private static class StationsEditorModel {

        private Station station;
        private StringProperty stationNameProperty = new SimpleStringProperty();
        private StringProperty stationCodeProperty = new SimpleStringProperty();
        private StringProperty stationRoadProperty = new SimpleStringProperty();
        private StringProperty stationParagraphProperty = new SimpleStringProperty();

        

        public StationsEditorModel() {

        }
        public StationsEditorModel(Station st) {
            
            station=st;
            stationNameProperty.setValue(st.getStationName());
            stationCodeProperty.setValue(st.getStationCode());
            stationRoadProperty.setValue(st.getStationRoad());
            stationParagraphProperty.setValue(st.getStationParagraph());

        }
        
        }
    }
    
  

