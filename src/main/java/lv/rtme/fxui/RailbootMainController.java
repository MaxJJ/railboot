/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javax.annotation.PostConstruct;
import lv.rtme.entities.CodesOrders;
import lv.rtme.fxui.models.CodesOrderModel;
import lv.rtme.repositories.CodesOrdersRepository;
import lv.rtme.repositories.StationRepository;
import lv.rtme.services.CodesTableItem;
import lv.rtme.services.CodesTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;




public class RailbootMainController {
    
 private Logger logger = LoggerFactory.getLogger(RailbootMainController.class);
 @Autowired private CodesOrdersRepository repository;
 @Autowired private CodesTableService service;
 @Autowired private CodesOrderModel model;
 @Autowired private StationRepository stationRepository;
 
 // MAIN TABLE BEGIN
    @FXML private TableView<CodesTableItem> codesOrdersTable;
    @FXML private TableColumn<CodesTableItem, String> fileID;
    @FXML private TableColumn<CodesTableItem, String> stDispatch;
    @FXML private TableColumn<CodesTableItem, String> stDestination;
    @FXML private TableColumn<CodesTableItem, String> cargo; 
    @FXML private TableColumn<CodesTableItem, String> wagon;
    @FXML private TableColumn<CodesTableItem, String> container;
    @FXML private TableColumn<CodesTableItem, String> rate;
    
    // MAIN TABLE END
    
    // TOP PANEL BEGIN
    @FXML private Text file ;
    @FXML private Text stDispText;
    @FXML private Text stDestText;
    @FXML private Text consiText;
    
    // TOP PANEL END
    
    // EDITING FORM BEGIN
    @FXML private TextField fileField;
    @FXML private Button copyButton;
    @FXML private Button newButton;
    @FXML private ComboBox<String> stDestCombo;
    @FXML private ComboBox<String> stDispCombo;
    @FXML private TextArea consiArea;
    @FXML private TextField wagonField;
    @FXML private TextField containerField;
    @FXML private TextField weightField;
    @FXML private TextField tareField;
    @FXML private TextArea cargoArea;
    @FXML private TextField providerField;
    @FXML private TextField payRoadsField;
    @FXML private TextField rateField;
    @FXML private TextField rateCurrencyField;
    @FXML private TextField securCurrencyField;
    @FXML private TextField securityRateField;
    @FXML private Button saveButton;
    
    // EDITING FORM END
    
    private ObservableList<CodesTableItem> data ;
    private ObservableList<String> stations = FXCollections.observableArrayList();
    @Qualifier("testbean")
    @Autowired
    private ObservableList<String> kuku;
    
    private TableRow<CodesTableItem> row;
    
    
    @FXML
    public void initialize() {
    }
    
    
     @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        stDestCombo.setItems(kuku);
        stDispCombo.setItems(kuku);
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
            
            if (node instanceof TableRow) {
                row = (TableRow) node;
            } else { // clicking on text part
                row = (TableRow) node.getParent();
                
            }

            model.init((CodesTableItem) row.getItem());
            file.setText(model.getFileID());
            stDestText.setText(model.getStationOfDestination().getStationName());
            stDispText.setText(model.getStationOfDispatch().getStationName());
            consiText.setText(model.getConsignee().getSampleName());
            
            //--------------
            
            fileField.setText(model.getFileID());
            fileField.setEditable(false);
            stDestCombo.setValue(model.getStationOfDestination().getStationName());
            consiArea.setText(model.getConsignee().getSampleName());
            cargoArea.setText(model.getCargo());
            containerField.setText(model.getUnit());
            
        }
    }
});
    }
      @FXML
      @Transactional
     public void addItem() {
//        CodesOrders codes = new CodesOrders();
//        codes.setFileID(fileField.getText());
//       repository.save(codes);
service.getData().get(row.getIndex()).setCargo(new SimpleStringProperty(cargoArea.getText()));
CodesOrders cd =row.getItem().getCodesOrders().getValue();
cd.setCargo(cargoArea.getText());
repository.save(cd);
//          System.out.println("button clicked ---"+kuku);
    }
    
    }
   
   
    

