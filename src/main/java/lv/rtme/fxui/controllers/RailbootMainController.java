/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.controllers;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javax.annotation.PostConstruct;
import lombok.Getter;
import lv.rtme.fxui.mainView.actions.RailbootMainActions;
import lv.rtme.fxui.mainView.settings.RailbootMainViewSettings;
import lv.rtme.fxui.models.CodesOrdersProperties;
import lv.rtme.repositories.CodesOrdersRepository;
import lv.rtme.services.ReadAndPopulate;
import lv.rtme.services.ReportPrintService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;



@SuppressWarnings("SpringJavaAutowiringInspection")
public class RailbootMainController {
    
    
      
    /*---------AUTOWIRED---------*/
    @Autowired
    private RailbootMainViewSettings set;
    @Autowired
    CodesOrdersRepository codesOrdersRepository;
    
    @Autowired
    ReadAndPopulate readerX;
    
    
    @Autowired
    RailbootMainActions actions;
    
    @Autowired
    ReportPrintService printer;
    
    /*  CONTROLLERS FIELDS  */
    private Logger logger = LoggerFactory.getLogger(RailbootMainController.class);
    private ArrayList<Node> oblist = new ArrayList<>();
    /* FXML FIELDS */
    @FXML @Getter
    private TableView<CodesOrdersProperties> codesOrdersTable;
 
    @FXML @Getter
    private TextField searchTextField;
    @FXML @Getter
    private TableColumn<CodesOrdersProperties, String> fileID;
    @FXML @Getter
    private TableColumn<CodesOrdersProperties, String> stDispatch;
    @FXML @Getter
    private TableColumn<CodesOrdersProperties, String> stDestination;
    @FXML @Getter
    private TableColumn<CodesOrdersProperties, String> cargo;
    @FXML @Getter
    private TableColumn<CodesOrdersProperties, String> wagon;
    @FXML @Getter
    private TableColumn<CodesOrdersProperties, String> container;
    @FXML @Getter
    private TableColumn<CodesOrdersProperties, String> rate;
    @FXML @Getter
    private TableColumn<CodesOrdersProperties, String> descriptionColumn;
    @FXML @Getter
    private MenuButton fileMenuButton;
    @FXML @Getter
    private MenuItem fileMenuButtonEdit;
    @FXML @Getter
    private MenuItem fileMenuButtonCopy;
    @FXML @Getter
    private MenuItem fileMenuButtonOrder;
    @FXML @Getter
    private MenuItem fileMenuButtonRequestRate;
    @FXML @Getter
    private AnchorPane appAnchorPane;
    @FXML @Getter
    private VBox tableVbox;
    
    /*-----------------------------------------------------------------------------------------*/

   public void initialize() {  }
   
   
    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
//     readerX.init();
//     List<CodesOrders> x = codesOrdersRepository.findAll();
//        for (CodesOrders codesOrders : x) {
//            
//           String st="";
//           st=st.concat(codesOrders.getFileID().concat(codesOrders.getProvider()));
//           codesOrders.setSearchString(st);
//           codesOrdersRepository.save(codesOrders);
//            
//        }
     
        setTable();
        set.searchTextField();
        set.fileMenuButtonItems();
   
    }
            

    public void setTable(){
        
        set.table();
        set.fileMenuButtonItems();
    }
   

    
    
 }
        
    