/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView.settings;

import java.util.List;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import lv.rtme.entities.CodesOrders;
import lv.rtme.fxui.mainView.RailbootMainController;
import lv.rtme.fxui.models.CodesOrderModel;
import lv.rtme.repositories.CodesOrdersRepository;
import lv.rtme.services.CodesTableService;
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
    private CodesTableService service;
    @Autowired
    CodesOrdersRepository codesOrdersRepository;
    
    public void table() {
        System.out.println(controller+"----------11111111111111-----------------------------");
        System.out.println(controller.getCodesOrdersTable()+"-------------2222222222222222------------");
      controller.getCodesOrdersTable().setItems(observableCodesOrderModelList(codesOrdersRepository.findAll()));
        controller.getFileID().setCellValueFactory((TableColumn.CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getFileIdProperty());
        controller.getCargo().setCellValueFactory((TableColumn.CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getCargoProperty());
        controller.getStDispatch().setCellValueFactory((TableColumn.CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getStationOfDispatchProperty());
        controller.getStDestination().setCellValueFactory((TableColumn.CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getStationOfDestinationProperty());
        controller.getWagon().setCellValueFactory((TableColumn.CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getWagonProperty());
        controller.getContainer().setCellValueFactory((TableColumn.CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getUnitProperty());
        controller.getRate().setCellValueFactory((TableColumn.CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getRateProperty());
        
    }
    
    public void searchTextField() {
      
         controller.getSearchTextField().textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (newValue.length() > 2) {
                controller.getCodesOrdersTable().getItems().clear();
                List<CodesOrders> que = codesOrdersRepository.findBySearchStringLikeIgnoreCase("%" + newValue + "%");
                controller.getCodesOrdersTable().setItems(observableCodesOrderModelList(que));
                
            }
        });
    }
    
/**
 * 
 * @return ObservableList<CodesOrderModel>
 */
    private ObservableList<CodesOrderModel> observableCodesOrderModelList(List<CodesOrders> list) {
        
        service.setInList(list);
        return service.getData();
    }

    
}
