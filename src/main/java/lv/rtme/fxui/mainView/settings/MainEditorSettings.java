/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView.settings;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.StringConverter;
import lv.rtme.entities.Station;
import lv.rtme.fxui.mainView.MainEditorController;
import lv.rtme.fxui.mainView.RailbootMainController;
import lv.rtme.fxui.mainView.actions.MainEditorActions;
import lv.rtme.fxui.models.CodesOrdersProperties;
import lv.rtme.fxui.models.TableItemsProperty;
import lv.rtme.repositories.CodesOrdersRepository;
import lv.rtme.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */
@Component
public class MainEditorSettings {

    @Autowired
    private MainEditorController controller;
    @Autowired
    RailbootMainController homeController;
   
    @Autowired
    CodesOrdersRepository codesOrdersRepository;
    @Autowired
    StationRepository stationRepository;
    @Autowired
    CodesOrdersProperties codesOrdersProperties;
    @Autowired
    TableItemsProperty tableItemsProperty;
    @Autowired
    MainEditorActions act;

    public void homeButton() {
        
     Button home=   controller.getHomeButton();
     home.setOnAction((eh)->{
         
//         CodesOrders x=new CodesOrders();
//        codesOrdersProperties.setCodesOrders(x);
        homeController.getAppAnchorPane().getChildren().clear();
        homeController.getAppAnchorPane().getChildren().add(homeController.getTableVbox());
        
     });
       
    }

    public void editorsFieldsBindings() {
       
        controller.getFileEditorFileIdTextField().textProperty().bindBidirectional(codesOrdersProperties.getFileIdProperty());
        controller.getFileEditorDescriptionTextArea().textProperty().bindBidirectional(codesOrdersProperties.getCustomTagProperty());
        controller.getStationsEditorStDispHLink().textProperty().bind(codesOrdersProperties.getStationOfDispatchProperty());
        controller.getStationsEditorStDestHLink().textProperty().bind(codesOrdersProperties.getStationOfDestinationProperty());
        
    }

    public void navigation() {
       controller.getFileHLink().setOnAction((eh)->{act.whenFileLinkClicked();});
       controller.getStationsHLink().setOnAction((eh)->{act.whenStationLinkClicked();});
        
    }

    public void editors() {
  
     
      setStationsEditor();
    }

    private void setStationsEditor() {
        setStationList();
        setHLinks();
        
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
    

    

    
}
