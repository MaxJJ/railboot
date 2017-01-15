/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView.actions;

import java.util.List;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.annotation.PostConstruct;
import lv.rtme.entities.CodesOrders;
import lv.rtme.fxui.mainView.ApplicationViewsAndControllers;
import lv.rtme.fxui.mainView.MainTableViewController;
import lv.rtme.fxui.mainView.actions.TopPaneActions;
import lv.rtme.fxui.models.CodesOrderModel;
import lv.rtme.repositories.CodesOrdersRepository;
import lv.rtme.services.CodesTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */
@Component
public class MainTableViewActions {
    @Qualifier("mainTableView")
    @Autowired
    private ApplicationViewsAndControllers.View mainTableView;

    private MainTableViewController mainTableViewController;

    @Qualifier("coModel")
    @Autowired
    private CodesOrderModel model;
    @Autowired
    private CodesOrdersRepository repository;
    @Autowired
    private CodesTableService service;
    @Autowired
    TopPaneActions topPaneActions;
     
       @PostConstruct
    void setController(){
        
        mainTableViewController= (MainTableViewController) mainTableView.getController();
    } 
    
  
    public void initializer(){
       initMainTable(); 
       setMainTableItemSelectionActions();
       setSearchTextField(); 
       setShowAllButton();
       
    }

    public Node showMainTableView() {
     
      return mainTableView.getView();
    }

    private void initMainTable() {
        
       fileID().setCellValueFactory((TableColumn.CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getFileIdProperty());
        cargo().setCellValueFactory((TableColumn.CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getCargoProperty());
        stDispatch().setCellValueFactory((TableColumn.CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getStationOfDispatchProperty());
        stDestination().setCellValueFactory((TableColumn.CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getStationOfDestinationProperty());
        wagon().setCellValueFactory((TableColumn.CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getWagonProperty());
        container().setCellValueFactory((TableColumn.CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getUnitProperty());
        rate().setCellValueFactory((TableColumn.CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getRateProperty());  
        
    }

    
    private void setSearchTextField() {
       searchTextField().textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (newValue.length() > 2) {
                codesOrdersTable().getItems().clear();
                List<CodesOrders> que = repository.findBySearchStringLikeIgnoreCase("%" + newValue + "%");
                service.setInList(que);
//                data = service.getData();
                codesOrdersTable().setItems(service.getData());
            }
        });
        
    }
    
    private void setShowAllButton() {

       showAllButton().setOnAction((event) -> {

            codesOrdersTable().getItems().clear();
            service.setInList(repository.findAll());
//        data=service.getData();
            codesOrdersTable().setItems(service.getData());

        });

    }
    
    
    /* Main Table Controllers fields */
    
    private TableColumn<CodesOrderModel, String> fileID() {
      return mainTableViewController.getFileID();
    }

    private TableColumn<CodesOrderModel, String> cargo() {
        return  mainTableViewController.getCargo();
    }

    private TableColumn<CodesOrderModel, String>stDispatch() {
      
        return  mainTableViewController.getStDispatch();
    }

    private TableColumn<CodesOrderModel, String> stDestination() {
      return  mainTableViewController.getStDestination();
        
    }

    private TableColumn<CodesOrderModel, String> wagon() {
        return  mainTableViewController.getWagon();
    }

    private TableColumn<CodesOrderModel, String> container() {
     
        return  mainTableViewController.getContainer();
    }

    private TableColumn<CodesOrderModel, String> rate() {
        return  mainTableViewController.getRate();
    }

    private TableView<CodesOrderModel> codesOrdersTable() {
      return mainTableViewController.getCodesOrdersTable();
    }

    private TextField searchTextField() {
        
        return  mainTableViewController.getSearchTextField();
    }

    private Button showAllButton() {
        
        return mainTableViewController.getShowAllButton();
    }

    private void setMainTableItemSelectionActions() {
          codesOrdersTable().setOnMousePressed((MouseEvent event) -> {
        if (event.isPrimaryButtonDown() && event.getClickCount() == 1) {
            
           CodesOrders coCheck =  codesOrdersTable().getSelectionModel().getSelectedItem().getCodesOrders();
           if(coCheck !=null && !coCheck.getFileID().isEmpty()){
            model.init(coCheck);

topPaneActions.showInfo();
           }
        }
        });
    
    codesOrdersTable().setOnKeyPressed((KeyEvent event) -> {
        if (event.getCode()==KeyCode.ENTER || event.getCode()==KeyCode.SPACE) {
            
           CodesOrders coCheck =  codesOrdersTable().getSelectionModel().getSelectedItem().getCodesOrders();
           if(coCheck !=null && !coCheck.getFileID().isEmpty()){
            model.init(coCheck);
         topPaneActions.showInfo();
           }
        }
        }); 
    }

    
    
    
}
