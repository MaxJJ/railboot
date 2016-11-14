/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui;

import java.util.List;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.annotation.PostConstruct;
import lv.rtme.ConfigurationControllers;
import lv.rtme.entities.CodesOrders;
import lv.rtme.fxui.models.CodesOrderModel;
import lv.rtme.reportsService.ReportPrintService;
import lv.rtme.repositories.CodesOrdersRepository;
import lv.rtme.repositories.StationRepository;
import lv.rtme.services.CodesTableService;
import lv.rtme.services.ReadAndPopulate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;



@SuppressWarnings("SpringJavaAutowiringInspection")
public class RailbootMainController {
   
    @Qualifier("searchView")
    @Autowired
    private ConfigurationControllers.View view;

    private Logger logger = LoggerFactory.getLogger(RailbootMainController.class);
    @Autowired
    UtilBeansCollection utils;
    @Autowired
    ReadAndPopulate readerX;
    @Autowired
    ReportPrintService printer;

    @Autowired
    private CodesOrdersRepository repository;
    @Autowired
    private CodesTableService service;
    @Autowired
    private CodesOrderModel model;
    @Autowired
    private StationRepository stationRepository;
 
     @FXML
    private Button addStationButton;

    @FXML
    private Button addConsigneeButton;

    @FXML
    private Button showAllButton;
    @FXML
    private TextField searchTextField;

    @FXML
    private Button selectButton;
     
 // MAIN TABLE BEGIN
    @FXML private TableView<CodesOrderModel> codesOrdersTable;
    @FXML private TableColumn<CodesOrderModel, String> fileID;
    @FXML private TableColumn<CodesOrderModel, String> stDispatch;
    @FXML private TableColumn<CodesOrderModel, String> stDestination;
    @FXML private TableColumn<CodesOrderModel, String> cargo; 
    @FXML private TableColumn<CodesOrderModel, String> wagon;
    @FXML private TableColumn<CodesOrderModel, String> container;
    @FXML private TableColumn<CodesOrderModel, String> rate;
    
    // MAIN TABLE END
    
    // TOP PANEL BEGIN
    @FXML private AnchorPane tableAnchorPane;
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
    
    
    
//    @Qualifier("stationsComboBox")
//    @Autowired
//    private ObservableList<String> stationsCombo;
    
    private TableRow<CodesOrderModel> row;
    private ObservableList<CodesOrderModel> data ;
    
    @FXML    public void initialize() {  }
    
    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        /* initial parsing of excell file       */
        readerX.init();
        
        /* setting combos with station     */
        stDestCombo.setItems(utils.strbean());
        stDispCombo.setItems(utils.strbean());
        
         /* setting ObservableList<CodesOrderModel> for TableView<CodesOrderModel> codesOrdersTable   */
        utils.setSearch();
        addStationButton.setOnAction((ActionEvent event) -> {
            Stage newStage = new Stage();
            newStage.showAndWait();
        });
        searchTextField.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (newValue.length() > 2) {
                codesOrdersTable.getItems().clear();
                List<CodesOrders> que = repository.findBySearchStringLike("%" + newValue + "%");
                service.setInList(que);
                data = service.getData();
                codesOrdersTable.setItems(data);
            }
        });
       
        fileID.setCellValueFactory((CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getFileIdProperty());
        cargo.setCellValueFactory((CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getCargoProperty());
        stDispatch.setCellValueFactory((CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getStationOfDispatchProperty());
        stDestination.setCellValueFactory((CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getStationOfDestinationProperty());
        wagon.setCellValueFactory((CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getWagonProperty());
        container.setCellValueFactory((CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getUnitProperty());
        rate.setCellValueFactory((CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getRateProperty());
    
    codesOrdersTable.setOnMousePressed((MouseEvent event) -> {
        if (event.isPrimaryButtonDown() && event.getClickCount() == 1) {
            Node node = ((Node) event.getTarget()).getParent();

            if (node instanceof TableRow) {
                row = (TableRow) node;
            } else { // clicking on text part
                row = (TableRow) node.getParent();

            }
            model.init(row.getItem().getCodesOrdersProperty().get());
           
            
            //--------------
            
            fileField.setText(model.getCodesOrders().getFileID());
            fileField.setEditable(false);
            stDispCombo.setValue(model.getCodesOrders().getStationOfDispatch().getStationName());
            stDestCombo.setValue(model.getCodesOrders().getStationOfDestination().getStationName());
            consiArea.setText(model.getCodesOrders().getConsignee().getSampleName());
            cargoArea.setText(model.getCodesOrders().getCargo());
            containerField.setText(model.getCodesOrders().getUnit());
            wagonField.setText(model.getCodesOrders().getWagon());
            weightField.setText(model.getCodesOrders().getWeight());
            rateField.setText(model.getCodesOrders().getRate());
            rateCurrencyField.setText(model.getCodesOrders().getRateCurrency());
            providerField.setText(model.getCodesOrders().getProvider());
            payRoadsField.setText(model.getCodesOrders().getRoadsToPay());
            weightField.setText(model.getCodesOrders().getWeight());
        }
        });
    }
    
     @FXML
    @Transactional
    public void addItem() {
        
   CodesOrders co= model.getCodesOrders();
   
   co.setFileID(fileField.getText()); 
   co.setStationOfDispatch(stationRepository.findByStationName(stDispCombo.getValue()).get(0));
   co.setStationOfDestination(stationRepository.findByStationName(stDestCombo.getValue()).get(0));
   
//   consiArea.setText(model.getConsignee().getSampleName());
     co.setCargo(cargoArea.getText());
//    containerField.setText(model.getUnit());
//    wagonField.setText(model.getWagon());
//    weightField.setText(model.getWeight());
//    rateField.setText(model.getRate());
//    rateCurrencyField.setText(model.getRateCurrency());
//    providerField.setText(model.getProvider());
//    payRoadsField.setText(model.getRoadsToPay());
//    weightField.setText(model.getWeight());
// try{ repository.save(co);
// CodesOrders coor = repository.findOne(co.getId());
//CodesOrderModel codesTableItem = data.get(row.getIndex());
//     BeanUtils.copyProperties(codesTableItem, coor);
//     codesTableItem.init();
//     System.out.println(codesTableItem.getCargo());
// }
// catch(Exception e){ e.printStackTrace();}

repository.save(co);
CodesOrders comod = repository.findOne(co.getId());
model.init(comod);
codesOrdersTable.getItems().set(row.getIndex(),model );


}
    
    @FXML
    void fillAllItems(){
        codesOrdersTable.getItems().clear();
        service.setInList(repository.findAll());
        data=service.getData();
        codesOrdersTable.setItems(data) ;
        
    } 
    
    
 }
        
    