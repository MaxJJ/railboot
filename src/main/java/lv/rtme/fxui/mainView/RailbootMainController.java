/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.annotation.PostConstruct;
import lombok.Getter;
import lv.rtme.ConfigurationControllers;
import lv.rtme.fxui.MainViewUtils;
import lv.rtme.fxui.UtilBeansCollection;
import lv.rtme.fxui.mainView.actions.RailbootMainActions;
import lv.rtme.fxui.mainView.settings.RailbootMainViewSettings;
import lv.rtme.fxui.models.CodesOrderModel;
import lv.rtme.reportsService.ReportPrintService;
import lv.rtme.services.ReadAndPopulate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;



@SuppressWarnings("SpringJavaAutowiringInspection")
public class RailbootMainController {
    
    
      
    /*---------AUTOWIRED---------*/
    @Autowired
    private RailbootMainViewSettings set;
    
    
    @Autowired
    ReadAndPopulate readerX;
    @Qualifier("stationsEditor")
    @Autowired
    private ConfigurationControllers.View stationsEditorView;
    
    @Qualifier("topPaneView")
     @Autowired
     ApplicationViewsAndControllers.View topPaneView;
    @Autowired
    UtilBeansCollection utils;
    @Autowired
    MainViewUtils mvu;
    
    @Autowired
    RailbootMainActions actions;
    
    @Autowired
    ReportPrintService printer;
    
    /*  CONTROLLERS FIELDS  */
    private Logger logger = LoggerFactory.getLogger(RailbootMainController.class);
    private ArrayList<Node> oblist = new ArrayList<>();
    /* FXML FIELDS */
    @FXML @Getter
    private TableView<CodesOrderModel> codesOrdersTable;
 
    @FXML @Getter
    private TextField searchTextField;
    @FXML @Getter
    private AnchorPane tableAnchorPane;
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
    
    /*-----------------------------------------------------------------------------------------*/

   public void initialize() {  }
   
   
    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
     
        set.table();
        set.searchTextField();
   
    }
            

    
   

    
    
 }
        
    