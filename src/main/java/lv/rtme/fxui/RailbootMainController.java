/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Callback;
import javax.annotation.PostConstruct;
import lv.rtme.entities.CodesOrders;
import lv.rtme.fxui.models.CodesOrderModel;
import lv.rtme.reportsService.ReportPrintService;
import lv.rtme.repositories.CodesOrdersRepository;
import lv.rtme.repositories.StationRepository;
import lv.rtme.services.CodesTableItem;
import lv.rtme.services.CodesTableService;
import lv.rtme.services.ReadAndPopulate;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;



@SuppressWarnings("SpringJavaAutowiringInspection")
public class RailbootMainController {
    
 private Logger logger = LoggerFactory.getLogger(RailbootMainController.class);
 
 @Autowired ReadAndPopulate readerX;
 @Autowired ReportPrintService printer;
 
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
    
    // SEARCH BEGIN
       @FXML
    private Button searchButton;

    @FXML
    private TextField searchText;

    @FXML
    private ListView<String> searchResultList;
    
    @FXML
    private AnchorPane webAnchor;
    
    private WebEngine engine;
    
    // SEARCH END
    private ObservableList<CodesTableItem> data ;
    private ObservableList<String> stations = FXCollections.observableArrayList();
    @Qualifier("stationsComboBox")
    @Autowired
    private ObservableList<String> stationsCombo;
    
    private TableRow<CodesTableItem> row;
    
    
    @FXML
    public void initialize() {
    }
    
    
    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
//        readerX.init();
        stDestCombo.setItems(stationsCombo);
        stDispCombo.setItems(stationsCombo);
        
        service.setInList(repository.findAll());
        data=service.getData();
        
 fileID.setCellValueFactory(new Callback<CellDataFeatures<CodesTableItem, String>, ObservableValue<String>>() {
     public ObservableValue<String> call(CellDataFeatures<CodesTableItem, String> p) {
         return p.getValue().getFileIdProperty();
     }
  });  
         cargo.setCellValueFactory((CellDataFeatures<CodesTableItem, String> p) -> p.getValue().getCargoProperty());
         stDispatch.setCellValueFactory((CellDataFeatures<CodesTableItem, String> p) -> p.getValue().getStationOfDispatchProperty());
         stDestination.setCellValueFactory((CellDataFeatures<CodesTableItem, String> p) -> p.getValue().getStationOfDestinationProperty());
         wagon.setCellValueFactory((CellDataFeatures<CodesTableItem, String> p) -> p.getValue().getWagonProperty());
         container.setCellValueFactory((CellDataFeatures<CodesTableItem, String> p) -> p.getValue().getUnitProperty());
         rate.setCellValueFactory((CellDataFeatures<CodesTableItem, String> p) -> p.getValue().getRateProperty());

    codesOrdersTable.setItems(data) ;
    
    codesOrdersTable.setOnMousePressed(new EventHandler<MouseEvent>() {
    @Override 
    public void handle(MouseEvent event) {
        if (event.isPrimaryButtonDown() && event.getClickCount() == 1) {
            Node node = ((Node) event.getTarget()).getParent();

            if (node instanceof TableRow) {
                row = (TableRow) node;
            } else { // clicking on text part
                row = (TableRow) node.getParent();

            }
            try {
                CodesOrders cti = row.getItem().getCodesOrdersProperty().get();
                BeanUtils.copyProperties(model, cti);
                model.setCodesOrders(cti);

            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(RailbootMainController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                java.util.logging.Logger.getLogger(RailbootMainController.class.getName()).log(Level.SEVERE, null, ex);
            }
            file.setText(model.getFileID());
            stDestText.setText(model.getStationOfDestination().getStationName());
            stDispText.setText(model.getStationOfDispatch().getStationName());
            consiText.setText(model.getConsignee().getSampleName());
            
            //--------------
            
            fileField.setText(model.getFileID());
            fileField.setEditable(false);
            stDispCombo.setValue(model.getStationOfDispatch().getStationName());
            stDestCombo.setValue(model.getStationOfDestination().getStationName());
            consiArea.setText(model.getConsignee().getSampleName());
            cargoArea.setText(model.getCargo());
            containerField.setText(model.getUnit());
            wagonField.setText(model.getWagon());
            weightField.setText(model.getWeight());
            rateField.setText(model.getRate());
            rateCurrencyField.setText(model.getRateCurrency());
            providerField.setText(model.getProvider());
            payRoadsField.setText(model.getRoadsToPay());
            weightField.setText(model.getWeight());
        }
    }
});
 
  
   
        searchText.textProperty().addListener((oservable, oldValue, newValue) -> {
            searchResultList.getItems().clear();
            List<CodesOrders> que = repository.findByCargoLike("%" + newValue + "%");
            ObservableList<String> resList = FXCollections.observableArrayList();
            int i = 1;
            for (CodesOrders codesOrders : que) {

                resList.add(i + " ФАЙЛ " + codesOrders.getFileID() + "-----");
                resList.add(codesOrders.getCargo());
                i++;
            }
            searchResultList.setItems(resList);

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
 try{ repository.save(co);
 CodesOrders coor = repository.findOne(co.getId());
 
// CodesTableItem codesTableItem = codesOrdersTable.getItems().get(row.getIndex());
CodesTableItem codesTableItem = data.get(row.getIndex());
     BeanUtils.copyProperties(codesTableItem, coor);
     codesTableItem.init();
     System.out.println(codesTableItem.getCargo());
//     data.add(codesTableItem);
 

     

 }
 catch(Exception e){ e.printStackTrace();}
 

 
// printer.setModel(model);
 printer.printThis();
}
    
 @FXML
 public void searchAction(){
    
     
     searchResultList.getItems().clear();
     List<CodesOrders> que = repository.findByCargoLike("%"+searchText.getText()+"%");
 ObservableList<String> resList = FXCollections.observableArrayList();
 String content = "<h1>BEGIN</h1><br/>";
     int i = 1;
         for (CodesOrders codesOrders : que) {
             
             resList.add(i+" ФАЙЛ "+codesOrders.getFileID()+ "-----" );
             resList.add(codesOrders.getCargo());
             content=content.concat("<p><b>"+codesOrders.getFileID()+"</b><span>  "+codesOrders.getProvider()+"  "+codesOrders.getRate()+codesOrders.getRateCurrency()+"</span></p>" );
           content=  content.concat("<p>"+codesOrders.getCargo()+"</p>");
            i++;
         }
          
           WebView webView = new WebView();
           webView.setStyle("font-size:12px");
           webView.setPrefWidth(300);
           webView.setMaxWidth(350);
           webView.getEngine().loadContent(content,"text/html");
           
           webAnchor.getChildren().add(webView);
         
          
       searchResultList.setItems(resList);
       
      
 }
 
 
        
    }
    
    
   
   
    

