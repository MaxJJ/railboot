/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.AccessibleRole;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.StringConverter;
import javax.annotation.PostConstruct;
import lv.rtme.ConfigurationControllers;
import lv.rtme.entities.CodesOrders;
import lv.rtme.entities.Persons;
import lv.rtme.entities.Station;
import lv.rtme.fxui.models.CodesOrderModel;
import lv.rtme.reportsService.ReportPrintService;
import lv.rtme.repositories.CodesOrdersRepository;
import lv.rtme.repositories.PersonsRepository;
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
    private Logger logger = LoggerFactory.getLogger(RailbootMainController.class);
    private ArrayList<Node> oblist = new ArrayList<>();
    
    @Qualifier("stationsEditor")
    @Autowired
    private ConfigurationControllers.View stationsEditorView;
    @Qualifier("personsEditor")
    @Autowired
    private ConfigurationControllers.View personsEditorView;
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
    @Qualifier("coModel")
    @Autowired
    private CodesOrderModel model;
    @Autowired
    private StationRepository stationRepository;
    @Autowired
    private PersonsRepository personsRepository;
 
    private TableRow<CodesOrderModel> row;
    private ObservableList<CodesOrderModel> data ;

    
    @FXML
    private TextField searchTextField;
    
/* BUTTONS ---------------   -------------    */
    @FXML private Button selectButton;
    @FXML private Button addStationButton;
    @FXML private Button addConsigneeButton;
    @FXML private Button showAllButton;
     
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
    
    // EDITING FORM BEGIN
    @FXML private TextField fileField;
    @FXML private Button copyButton;
    @FXML private Button newButton;
    @FXML private ComboBox<Station> stDestCombo;
    @FXML private ComboBox<Station> stDispCombo;
    @FXML private ComboBox<Persons> consiNameCombo;
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
    
    
    @FXML    public void initialize() {  }
    
    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        
   
        
        /* initial parsing of excell file       */
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
      
        
        /* setting combos with station     */
        
     
        stDestCombo.itemsProperty().setValue(utils.strbean());
        stDestCombo.converterProperty().setValue(getStationConverter());
        
        stDispCombo.itemsProperty().setValue(utils.strbean());
        stDispCombo.converterProperty().setValue(getStationConverter());
        
        consiNameCombo.converterProperty().setValue(getPersonsConverter());
        
        ObservableList<String> list = FXCollections.observableArrayList();
         List<Persons> pl = personsRepository.findAllByOrderBySearchNameAsc();
     
         
         
           consiNameCombo.getItems().addAll(pl);
           
           consiNameCombo.valueProperty().addListener(new ChangeListener<Persons>() {
            @Override
            public void changed(ObservableValue<? extends Persons> observable, Persons oldValue, Persons newValue) {
                
                consiArea.setText(newValue.getSampleName());
            }
        });
            
        
         /* setting ObservableList<CodesOrderModel> for TableView<CodesOrderModel> codesOrdersTable   */
        utils.setSearch();
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
      
            model.init(row.getItem().getCodesOrders());
           
            
            //--------------
            consiNameCombo.setValue(model.getCodesOrders().getConsignee());
            fileField.setText(model.getCodesOrders().getFileID());
            fileField.setEditable(false);
            stDispCombo.setValue(model.getCodesOrders().getStationOfDispatch());
            stDestCombo.setValue(model.getCodesOrders().getStationOfDestination());
//            consiArea.setText(model.getCodesOrders().getConsignee().getSampleName());
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
        
          ObjectMapper om = new ObjectMapper();
        try {
            om.writeValue(new File("mymodel.json"), model);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(RailbootMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        });
    
      
    }
    
     @FXML
    @Transactional
    public void addItem() {
        
   CodesOrders co= model.getCodesOrders();
   
   co.setFileID(fileField.getText()); 
   co.setStationOfDispatch(stDispCombo.getValue());
   co.setStationOfDestination(stDestCombo.getValue());
   co.setCargo(cargoArea.getText());
   
repository.save(co);
CodesOrders comod = repository.findOne(co.getId());
model.init(comod);
codesOrdersTable.getItems().get(row.getIndex()).init(comod);


}
    
    @FXML
    void fillAllItems(){
        codesOrdersTable.getItems().clear();
        service.setInList(repository.findAll());
        data=service.getData();
        codesOrdersTable.setItems(data) ;
        
    }
    
    @FXML
    void stationsEditor (){
   
        openModal(stationsEditorView.getView());
  
        
    }
  
    
    
    
    
    private StringConverter<Station> getStationConverter(){
        
        return new StringConverter<Station>() {
            @Override
            public String toString(Station object) {
             String name = null;
                if(object!=null){
                name = object.getStationName();}
                else {name="pizdec!";}
                return name;
            }
            @Override
            public Station fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
    
    private StringConverter<Persons> getPersonsConverter(){
        
        return new StringConverter<Persons>() {
            @Override
            public String toString(Persons object) {
             String name = null;
                if(object!=null){
                name = object.getSearchName();}
                else {name="pizdec!";}
                return name;
            }
            @Override
            public Persons fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
    
    void openModal(Parent parent) {

        Scene checkScene = parent.getScene();
        if (checkScene != null) {
            checkScene.setRoot(new Region());
        }
        Stage newStage = new Stage();
        newStage.setScene(new Scene(parent));
        newStage.initModality(Modality.APPLICATION_MODAL);

        newStage.setOnCloseRequest((WindowEvent event) -> {
            System.out.println(parent + " is closed at" + LocalDateTime.now());

            Stage stage = (Stage) event.getSource();
            Parent root = stage.getScene().getRoot();

            getNodeList(root);

            for (Node node : oblist) {
                AccessibleRole role = node.getAccessibleRole();
                if (role == AccessibleRole.TEXT_FIELD) {
                    TextField field = (TextField) node;
                    field.setText("");
                    
                }
                
               stDestCombo.itemsProperty().setValue(utils.strbean());
        stDispCombo.itemsProperty().setValue(utils.strbean());
            }

        });

        newStage.showAndWait();
    }
    
   public  void getNodeList(Parent root){
       ObservableList<Node> li = root.getChildrenUnmodifiable();
       oblist.addAll(li);
       
       for (Node node : li) {
           
           if(node instanceof Parent){
               Parent par = (Parent) node;
               getNodeList(par);
           }
           
       }

   
    }
 }
        
    