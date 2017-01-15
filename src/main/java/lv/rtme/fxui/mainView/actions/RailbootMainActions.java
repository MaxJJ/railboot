/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView.actions;

import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javax.annotation.PostConstruct;
import lv.rtme.ConfigurationControllers;
import lv.rtme.fxui.mainView.ApplicationViewsAndControllers;
import lv.rtme.fxui.mainView.RailbootMainController;
import lv.rtme.fxui.models.CodesOrderModel;
import lv.rtme.repositories.CodesOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */

@Component
public class RailbootMainActions {
    
      @Qualifier("railbootMainView")
    @Autowired
    private ConfigurationControllers.View  railbootMainView;
      @Qualifier("mainTableView")
    @Autowired
    private ApplicationViewsAndControllers.View  mainTableView;
    
    private RailbootMainController railbootMainController; 
     
    @Autowired
    CodesOrdersRepository codesOrdersRepository;
    @Autowired
    TopPaneActions topPaneActions;
    @Autowired
    MainTableViewActions mainTableViewActions;
    @Autowired
    MainEditorActions mainEditorActions;
    
    @Qualifier("coModel")
    @Autowired
    private CodesOrderModel model;
    

 
    
    @PostConstruct
    void setController(){
        
        railbootMainController=(RailbootMainController) railbootMainView.getController();
    }
    

    
    public void initialSetting() {

        railbootMainController.getHomeTab().setContent(mainTableViewActions.showMainTableView());
  setNewButton();
  setEditButton();

    }

    private TableView<CodesOrderModel> codesOrdersTable() {
        return railbootMainController.getCodesOrdersTable();
    }

    private void deleteButton() {

        railbootMainController.getDeleteButton().setOnAction((event) -> {

            String text = "ФАЙЛ " + model.getCodesOrders().getFileID() + " УДАЛЕН";
            codesOrdersRepository.delete(model.getCodesOrders());
            topPaneActions.updateState();
            topPaneActions.getTopPaneController().getCenterStackPane().getChildren().clear();
            topPaneActions.getTopPaneController().getCenterStackPane().getChildren().add(new Text(text));

        });
    }

    private void setNewButton() {
        newButton().setOnAction((event) -> {
            
            topPaneActions.showMessage("НОВЫЙ ФАЙЛ");
            
            homeTab().setContent(mainEditorActions.showEmpty());

        });
    }

    private void setEditButton() {
     
 editButton().setOnAction((event)->{
     
     topPaneActions.showMessage("РЕДАКТИРУЕТСЯ ФАЙЛ - "+model.getFileIdProperty().getValueSafe());
      homeTab().setContent(mainEditorActions.showFilledWith(model.getCodesOrders()));
      
    
 });
    }
    private Button newButton() {
      
        return railbootMainController.getNewButton();
    }

    private Tab homeTab() {
        
     return railbootMainController.getHomeTab();
    }

    private Button editButton() {
      return railbootMainController.getEditButton();
    }


 
    
    
    
    
}
