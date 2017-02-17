/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView.settings;

import java.util.List;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lv.rtme.entities.CodesOrders;
import lv.rtme.fxui.controllers.RailbootMainController;
import lv.rtme.fxui.mainView.actions.RailbootMainActions;
import lv.rtme.fxui.models.CodesOrdersProperties;
import lv.rtme.fxui.models.TableItemsProperty;
import lv.rtme.repositories.CodesOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */
@Component
public class RailbootMainViewSettings {

    @Autowired
    private RailbootMainController controller;
   
    @Autowired
    CodesOrdersRepository codesOrdersRepository;
    @Autowired
    CodesOrdersProperties codesOrdersProperties;
    @Autowired
    TableItemsProperty tableItemsProperty;
    @Autowired
    RailbootMainActions act;
    
    public void table() {
        act.disactivateFileButton();
//       controller.getCodesOrdersTable().getItems().clear();
//       tableItemsProperty.setInList(codesOrdersRepository.findAll());
//      controller.getCodesOrdersTable().setItems(tableItemsProperty.getItemsProperty().getValue());
//      controller.getCodesOrdersTable().getItems().addAll(tableItemsProperty.getItemsProperty().getValue());
      
        controller.getFileID().setCellValueFactory((TableColumn.CellDataFeatures<CodesOrdersProperties, String> p) -> p.getValue().getFileIdProperty());
        controller.getCargo().setCellValueFactory((TableColumn.CellDataFeatures<CodesOrdersProperties, String> p) -> p.getValue().getCargoProperty());
        
        controller.getStDispatch().setCellValueFactory((TableColumn.CellDataFeatures<CodesOrdersProperties, String> p) -> p.getValue().getStationOfDispatchProperty());
        controller.getStDestination().setCellValueFactory((TableColumn.CellDataFeatures<CodesOrdersProperties, String> p) -> p.getValue().getStationOfDestinationProperty());
        controller.getWagon().setCellValueFactory((TableColumn.CellDataFeatures<CodesOrdersProperties, String> p) -> p.getValue().getWagonProperty());
        controller.getContainer().setCellValueFactory((TableColumn.CellDataFeatures<CodesOrdersProperties, String> p) -> p.getValue().getUnitProperty());
        controller.getRate().setCellValueFactory((TableColumn.CellDataFeatures<CodesOrdersProperties, String> p) -> p.getValue().getRateProperty());
        controller.getDescriptionColumn().setCellValueFactory((TableColumn.CellDataFeatures<CodesOrdersProperties, String> p) -> p.getValue().getCustomTagProperty());
        
        setTableSelectionHandlers();
    }
    
    public void searchTextField() {
      act.fillTableAll();
         controller.getSearchTextField().textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
           
                controller.getCodesOrdersTable().getItems().clear();
                List<CodesOrders> que = codesOrdersRepository.findBySearchStringLikeIgnoreCase("%" + newValue + "%");
                tableItemsProperty.setInList(que);
                controller.getCodesOrdersTable().setItems(tableItemsProperty.getItemsProperty().getValue());
        });
    }

    private void setTableSelectionHandlers() {
        
            controller.getCodesOrdersTable().setOnMousePressed((MouseEvent event) -> {
        if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {  act.whenCodesOrdersIsSelected();}
        });
    
    controller.getCodesOrdersTable().setOnKeyPressed((KeyEvent event) -> {
        if (event.getCode()==KeyCode.ENTER || event.getCode()==KeyCode.SPACE) {  act.whenCodesOrdersIsSelected();}
        }); 
    }

    public void fileMenuButtonItems() {
       
        controller.getFileMenuButtonEdit().setOnAction((eh)->{act.whenFileMenuButtonEditIsClicked();});
    }

    public void buttonCreate() {
       
        controller.getCreateButton().setOnAction((eh)->{act.whenCreateButtonisClicked();});
    }

    

    
}
