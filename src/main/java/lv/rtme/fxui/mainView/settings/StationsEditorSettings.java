/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView.settings;

import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.StringConverter;
import lv.rtme.entities.Station;
import lv.rtme.fxui.controllers.MainEditorController;
import lv.rtme.fxui.models.CodesOrdersProperties;
import lv.rtme.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component
public class StationsEditorSettings {
    
    @Autowired
    StationRepository stationRepository;
     @Autowired
    private MainEditorController controller;
      @Autowired
    CodesOrdersProperties codesOrdersProperties;
    
    public void editor() {
       setStationList();
        setHLinks();
        setStationsSearchTextField();
        
    }
    
     private void setStationList() {
             ObservableList<Station> ol = FXCollections.observableArrayList();
      ol.addAll(stationRepository.findAll());
      controller.getStationsEditorListView().getItems().addAll(ol);
      controller.getStationsEditorListView().setCellFactory((ListView<Station> param) -> {
          TextFieldListCell<Station> cell = new TextFieldListCell<>(new StringConverter<Station>() {
              @Override
              public String toString(Station object) {
                  return object.getStationName();
              }
              @Override
              public Station fromString(String string) {
                  
                  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
              }
          });
          
          return cell;
             });
      
      
    }
     
      private void setHLinks() {
        
        ChangeListener<Station> destination =  new ChangeListener<Station>() {
                    @Override
                    public void changed(ObservableValue<? extends Station> observable, Station oldValue, Station newValue) {
                        codesOrdersProperties.getStationOfDestinationProperty().setValue(newValue.getStationName());
                        codesOrdersProperties.getDestinationStationObjectProperty().setValue(newValue);
                    }
                };
        
        ChangeListener<Station> dispatch =  new ChangeListener<Station>() {
                    @Override
                    public void changed(ObservableValue<? extends Station> observable, Station oldValue, Station newValue) {
                        codesOrdersProperties.getStationOfDispatchProperty().setValue(newValue.getStationName());
                        codesOrdersProperties.getDispatchStationObjectProperty().setValue(newValue);
                    }
                };
        
        
        
        controller.getStationsEditorStDispHLink().setOnAction((ActionEvent eh) -> {
            
            controller.getStationsEditorStDispHLink().setStyle("-fx-background-color: yellow;");
            controller.getStationsEditorListView().requestFocus();
            controller.getStationsEditorListView().getSelectionModel().selectedItemProperty().removeListener(destination);
            controller.getStationsEditorListView().getSelectionModel().selectedItemProperty().removeListener(dispatch);
           controller.getStationsEditorListView().getSelectionModel().selectedItemProperty().addListener(dispatch);
        });
        controller.getStationsEditorStDestHLink().setOnAction((ActionEvent eh) -> {
            controller.getStationsEditorListView().requestFocus();
            controller.getStationsEditorListView().getSelectionModel().selectedItemProperty().removeListener(dispatch);
            controller.getStationsEditorListView().getSelectionModel().selectedItemProperty().removeListener(destination);
           controller.getStationsEditorListView().getSelectionModel().selectedItemProperty().addListener(destination);
        });
        
       
       
        
    }
      
       private void setStationsSearchTextField() {
        
    controller.getStationsEditorSearchTextField().textProperty().addListener((ObservableValue<? extends String> ov, String old, String newValue) -> {
        controller.getStationsEditorListView().getItems().clear();
        List<Station> list =   stationRepository.findByStationNameLikeIgnoreCase("%"+newValue+"%");
        controller.getStationsEditorListView().getItems().addAll(list);
    });
    
    controller.getStationsEditorSaveButton().setOnAction((eh)->{ 
        
       ObservableList<Station> ol = controller.getStationsEditorListView().getItems();
       
       if(ol.isEmpty()){
           
           Station station = new Station();
           station.setStationName(controller.getStationsEditorSearchTextField().getText());
           
           stationRepository.save(station);
           
           controller.getStationsEditorListView().getItems().add(station);
           controller.getStationsEditorListView().requestFocus();
       }
    });
                
        
        
    }

}
