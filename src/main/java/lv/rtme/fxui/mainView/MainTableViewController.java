/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.annotation.PostConstruct;
import lombok.Getter;
import lv.rtme.fxui.mainView.actions.MainTableViewActions;
import lv.rtme.fxui.models.CodesOrderModel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * FXML Controller class
 *
 * @author Maksims
 */
public class MainTableViewController implements Initializable {

    @FXML @Getter
    private TextField searchTextField;
    @FXML @Getter
    private Button notOrderedButton;
    @FXML @Getter
    private Button showAllButton;
    private Button newButton;
    @FXML @Getter
    private AnchorPane tableAnchorPane;
   
    @FXML @Getter
    private TableView<CodesOrderModel> codesOrdersTable;
    @FXML @Getter
    private TableColumn<CodesOrderModel, String> fileID;
    @FXML @Getter
    private TableColumn<CodesOrderModel, String> stDispatch;
    @FXML @Getter
    private TableColumn<CodesOrderModel, String> stDestination;
    @FXML @Getter
    private TableColumn<CodesOrderModel, String> cargo;
    @FXML @Getter
    private TableColumn<CodesOrderModel, String> wagon;
   @FXML @Getter
    private TableColumn<CodesOrderModel, String> container;
    @FXML @Getter
    private TableColumn<CodesOrderModel, String> rate;

    @Autowired MainTableViewActions actions ; 
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
      
       actions.initializer();
    }

//    public TextField getSearchTextField() {
//        return searchTextField;
//    }
//
//    public Button getNotOrderedButton() {
//        return notOrderedButton;
//    }
//
//    public Button getShowAllButton() {
//        return showAllButton;
//    }
//
//    public Button getNewButton() {
//        return newButton;
//    }
//
//    public AnchorPane getTableAnchorPane() {
//        return tableAnchorPane;
//    }
//
//    public TableView<CodesOrderModel> getCodesOrdersTable() {
//        return codesOrdersTable;
//    }
//
//    public TableColumn<CodesOrderModel, String> getFileID() {
//        return fileID;
//    }
//
//    public TableColumn<CodesOrderModel, String> getStDispatch() {
//        return stDispatch;
//    }
//
//    public TableColumn<CodesOrderModel, String> getStDestination() {
//        return stDestination;
//    }
//
//    public TableColumn<CodesOrderModel, String> getCargo() {
//        return cargo;
//    }
//
//    public TableColumn<CodesOrderModel, String> getWagon() {
//        return wagon;
//    }
//
//    public TableColumn<CodesOrderModel, String> getContainer() {
//        return container;
//    }
//
//    public TableColumn<CodesOrderModel, String> getRate() {
//        return rate;
//    }

    
    
}
