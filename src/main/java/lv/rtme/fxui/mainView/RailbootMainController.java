/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javax.annotation.PostConstruct;
import lv.rtme.ConfigurationControllers;
import lv.rtme.entities.CodesOrders;
import lv.rtme.entities.Persons;
import lv.rtme.fxui.UtilBeansCollection;
import lv.rtme.fxui.models.CodesOrderModel;
import lv.rtme.reportsService.ReportPrintService;
import lv.rtme.repositories.CodesOrdersRepository;
import lv.rtme.repositories.PersonsRepository;
import lv.rtme.repositories.StationRepository;
import lv.rtme.services.CodesTableService;
import lv.rtme.services.ReadAndPopulate;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.Glyph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;



@SuppressWarnings("SpringJavaAutowiringInspection")
public class RailbootMainController {
    
    /* FXML FIELDS */
      @FXML
    private VBox leftVBox;
    @FXML
    private Button copyButton;
    @FXML
    private Button copyButton1;
    @FXML
    private Button copyButton11;
    @FXML
    private HBox topCenterHBox;
    @FXML
    private TextField searchTextField;
    @FXML
    private Button notOrderedButton;
    @FXML
    private Button showAllButton;
    @FXML
    private Button newButton;
    @FXML
    private AnchorPane tableAnchorPane;
    @FXML
    private TableView<CodesOrderModel> codesOrdersTable;
    @FXML
    private TableColumn<CodesOrderModel, String> fileID;
    @FXML
    private TableColumn<CodesOrderModel, String> stDispatch;
    @FXML
    private TableColumn<CodesOrderModel, String> stDestination;
    @FXML
    private TableColumn<CodesOrderModel, String> cargo;
    @FXML
    private TableColumn<CodesOrderModel, String> wagon;
    @FXML
    private TableColumn<CodesOrderModel, String> container;
    @FXML
    private TableColumn<CodesOrderModel, String> rate;
    @FXML
    private FlowPane rightFlowPane;
    @FXML
    private Button readButton;
    /*---------AUTOWIRED---------*/
    
    @Autowired
    ReadAndPopulate readerX;
    @Qualifier("stationsEditor")
    @Autowired
    private ConfigurationControllers.View stationsEditorView;
    @Qualifier("personsEditor")
    @Autowired
    private ConfigurationControllers.View personsEditorView;
    @Qualifier("rightEditor")
    @Autowired
    private ConfigurationControllers.View rightEditorView;
    @Qualifier("topPaneView")
     @Autowired
     MainViewControllers.View topPaneView;
    @Autowired
    UtilBeansCollection utils;
    @Autowired
    ReportPrintService printer;
    @Autowired
    private CodesOrdersRepository repository;
    @Autowired
    private CodesTableService service;
    @Qualifier("coModel")
    @Autowired
    private CodesOrderModel model;
    @Autowired
    private StationRepository stationRepository;
    @Autowired
    private PersonsRepository personsRepository;
    @Autowired
    private CodesOrdersRepository codesOrdersRepository;
    
    /*  CONTROLLERS FIELDS  */
    private Logger logger = LoggerFactory.getLogger(RailbootMainController.class);
    private ArrayList<Node> oblist = new ArrayList<>();
    

    private TableRow<CodesOrderModel> row;
    private ObservableList<CodesOrderModel> data;
    
  
    /*-----------------------------------------------------------------------------------------*/

   public void initialize() {  }
   
   
    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        readButton.setText("");
        readButton.setGraphic(new Glyph("FontAwesome", FontAwesome.Glyph.EDIT));
        
        topCenterHBox.getChildren().addAll(topPaneView.getView().getChildrenUnmodifiable());
        readFromExcell();
        
        fileID.setCellValueFactory((CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getFileIdProperty());
        cargo.setCellValueFactory((CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getCargoProperty());
        stDispatch.setCellValueFactory((CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getStationOfDispatchProperty());
        stDestination.setCellValueFactory((CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getStationOfDestinationProperty());
        wagon.setCellValueFactory((CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getWagonProperty());
        container.setCellValueFactory((CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getUnitProperty());
        rate.setCellValueFactory((CellDataFeatures<CodesOrderModel, String> p) -> p.getValue().getRateProperty());
        
        
        searchTextField.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (newValue.length() > 2) {
                codesOrdersTable.getItems().clear();
                List<CodesOrders> que = repository.findBySearchStringLikeIgnoreCase("%" + newValue + "%");
                service.setInList(que);
                data = service.getData();
                codesOrdersTable.setItems(data);
            }
        });
       
      
    codesOrdersTable.setOnMousePressed((MouseEvent event) -> {
        if (event.isPrimaryButtonDown() && event.getClickCount() == 1) {
            Node node = ((Node) event.getTarget()).getParent();

            if (node instanceof TableRow) {
                row = (TableRow) node;
            } else { // clicking on text part
                row = (TableRow) node.getParent();

            }
            model.init(row.getItem().getCodesOrders());
      
        }
        });
    
    
    
    
    }
            
    
//    @Transactional
//    public void addItem() {
//        
//   CodesOrders co= model.getCodesOrders();
//   
//   co.setFileID(fileField.getText()); 
//   co.setStationOfDispatch(stDispCombo.getValue());
//   co.setStationOfDestination(stDestCombo.getValue());
//   co.setCargo(cargoArea.getText());
//   
//repository.save(co);
//CodesOrders comod = repository.findOne(co.getId());
//model.init(comod);
//codesOrdersTable.getItems().get(row.getIndex()).init(comod);
//
//
//}
    
    @FXML
    void fillAllItems(){
        codesOrdersTable.getItems().clear();
        service.setInList(repository.findAll());
        data=service.getData();
        codesOrdersTable.setItems(data) ;
        
    }
    
    

   /* reading from excell  */
    private void readFromExcell() {
         readButton.setOnAction((ActionEvent event) -> {
             readerX.init();
             List<Persons> persons =   personsRepository.findAll();
             for (Persons person : persons) {
                 if(person!=null){
                     String search = "";
                     String sample = person.getSampleName();
                     int l = sample.length();
                     if(l>=30){l=30;};
                     search = search.concat(sample.substring(0, l));
                     person.setSearchName(search);
                     personsRepository.save(person);
                 }
             }
             setSearch();
             readButton.setDisable(true);
             
              topCenterHBox.getChildren().addAll(getTop());
              rightFlowPane.getChildren().addAll(rightEditorView.getView().getChildrenUnmodifiable());
         });
    }

   /* setting setting SearchString field in @link CodesOrder */
    private void setSearch() {
        List<CodesOrders> list = codesOrdersRepository.findAll();
        String search = "";
        for (CodesOrders codesOrders : list) {
            search = search.concat(codesOrders.getFileID().concat(codesOrders.getProvider()));
            String cargo = codesOrders.getCargo();
            StringTokenizer cargoTok = new StringTokenizer(cargo);
            while (cargoTok.hasMoreElements()) {
                String nextElement = (String) cargoTok.nextElement();
                if (nextElement.length() > 4) {
                    search = search.concat(nextElement);
                }
            }
            codesOrders.setSearchString(search);
            codesOrdersRepository.save(codesOrders);
            search = "";
        }
    }

    private List< Node> getTop() {
        TextFlow textFlowOne = new TextFlow();
        List<Node> nodes = new ArrayList<>();
        LocalDate date = LocalDate.now();
        Text todayIsText=new Text(date.toString()+"\n");
        
        Text recordsText=new Text("Всего файлов - "+Long.toString(repository.count(), 0));
        textFlowOne.getChildren().addAll(todayIsText,recordsText);
        
        nodes.add(textFlowOne);
        
       return nodes;
    }
    
 }
        
    