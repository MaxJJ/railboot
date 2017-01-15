/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView;

import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javax.annotation.PostConstruct;
import lv.rtme.ConfigurationControllers;
import lv.rtme.fxui.MainViewUtils;
import lv.rtme.fxui.UtilBeansCollection;
import lv.rtme.fxui.mainView.actions.RailbootMainActions;
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
   
    @FXML
    private HBox topCenterHBox;
     
    @FXML
    private Button newButton;
  
    private TableView<CodesOrderModel> codesOrdersTable;
 
    @FXML
    private HBox toolHBox;
    @FXML
    private Tab homeTab;
    @FXML
    private StackPane homeTabStackPane;
    

    private TableRow<CodesOrderModel> row;
    private ObservableList<CodesOrderModel> data;
    @FXML
    private TabPane mainTabPane;
    @FXML
    private Button deleteButton;
    @FXML
    private Button copyButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button requestButton;
    @FXML
    private Button printCodesButton;
    @FXML
    private Tab stationsTab;
    @FXML
    private Tab personsTab;
    @FXML
    private Button editButton;
    @FXML
    private ToolBar requestToolBar;
    
    
   
    
  
    /*-----------------------------------------------------------------------------------------*/

   public void initialize() {  }
   
   
    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        
        actions.initialSetting();
        
        mvu.showHomeTab();
        mvu.setCombosItems();
        
        
        
        topCenterHBox.getChildren().addAll(topPaneView.getView().getChildrenUnmodifiable());
       
     
        
   
    }
            

    
    public StackPane getHomeTabStackPane() {
        return homeTabStackPane;
    }


    public Tab getHomeTab() {
       return homeTab;
    }
    public TabPane getHomeTabPane() {
       return mainTabPane;
    }

    public TableView<CodesOrderModel> getCodesOrdersTable() {
        return codesOrdersTable;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public Button getNewButton() {
        return newButton;
    }

    public Button getCopyButton() {
        return copyButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public Tab getStationsTab() {
        return stationsTab;
    }

    public Button getEditButton() {
        return editButton;
    }

    public Tab getPersonsTab() {
        return personsTab;
    }
   

    
    
 }
        
    