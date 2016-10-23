/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui;

import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javax.annotation.PostConstruct;
import lv.rtme.fxui.models.CodesOrderModel;
import lv.rtme.repositories.CodesOrdersRepository;
import lv.rtme.services.CodesTableItem;
import lv.rtme.services.CodesTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;




public class RailbootMainController {
    
 private Logger logger = LoggerFactory.getLogger(RailbootMainController.class);
 @Autowired private CodesOrdersRepository repository;
 @Autowired private CodesTableService service;
 @Autowired private CodesOrderModel model;
    @FXML
    private TableView<CodesTableItem> codesOrdersTable;

    @FXML
    private TableColumn<CodesTableItem, String> fileID;

    @FXML
    private TableColumn<CodesTableItem, String> stDispatch;

    @FXML
    private TableColumn<CodesTableItem, String> stDestination;

    @FXML
    private TableColumn<CodesTableItem, String> cargo; 
    
      @FXML
    private TableColumn<CodesTableItem, String> wagon;

    @FXML
    private TableColumn<CodesTableItem, String> container;
    
    
    @FXML
    private TableColumn<CodesTableItem, String> rate;
    
       @FXML
    private Text file ;

    @FXML
    private Text stDispText;

    @FXML
    private Text stDestText;
    @FXML
    private Text consiText;
    
    
    private ObservableList<CodesTableItem> data ;
    
    
    
    @FXML
    public void initialize() {
    }
    
    
     @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        service.setInList(repository.findAll());
        data=service.getData();
 fileID.setCellValueFactory(new Callback<CellDataFeatures<CodesTableItem, String>, ObservableValue<String>>() {
     public ObservableValue<String> call(CellDataFeatures<CodesTableItem, String> p) {
         return p.getValue().getFileID();
     }
  });  
   
         cargo.setCellValueFactory((CellDataFeatures<CodesTableItem, String> p) -> p.getValue().getCargo());

         stDispatch.setCellValueFactory((CellDataFeatures<CodesTableItem, String> p) -> p.getValue().getStationOfDispatch());

         stDestination.setCellValueFactory((CellDataFeatures<CodesTableItem, String> p) -> p.getValue().getStationOfDestination());

         wagon.setCellValueFactory((CellDataFeatures<CodesTableItem, String> p) -> p.getValue().getWagon());

         container.setCellValueFactory((CellDataFeatures<CodesTableItem, String> p) -> p.getValue().getUnit());

         rate.setCellValueFactory((CellDataFeatures<CodesTableItem, String> p) -> p.getValue().getRate());

    codesOrdersTable.setItems(data) ;
       
    
    
    
    codesOrdersTable.setOnMousePressed(new EventHandler<MouseEvent>() {
    @Override 
    public void handle(MouseEvent event) {
        if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
            Node node = ((Node) event.getTarget()).getParent();
            TableRow row;
            if (node instanceof TableRow) {
                row = (TableRow) node;
            } else {
                // clicking on text part
                row = (TableRow) node.getParent();
            }
            model.init((CodesTableItem) row.getItem());
            file.setText(model.getFile());
            stDestText.setText(model.getStDestination());
            stDispText.setText(model.getStDispatch());
            consiText.setText(model.getConsignee());
        }
    }
});
    }
   

}
