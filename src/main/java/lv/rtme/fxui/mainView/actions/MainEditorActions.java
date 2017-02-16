/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView.actions;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lv.rtme.entities.CodesOrders;
import lv.rtme.fxui.controllers.MainEditorController;
import lv.rtme.fxui.controllers.RailbootMainController;
import lv.rtme.fxui.mainView.settings.MainEditorSettings;
import lv.rtme.fxui.models.CodesOrdersProperties;
import lv.rtme.repositories.CodesOrdersRepository;
import lv.rtme.services.FileService;
import lv.rtme.services.ReportPrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */
@Component
public class MainEditorActions {
    
  
       
    @Autowired
    private  MainEditorController controller;
    @Autowired
    private  RailbootMainController homeController;
    @Autowired
    private CodesOrdersProperties codesOrdersProperties;
    @Autowired
    CodesOrdersRepository codesOrdersRepository;
   @Autowired
   ReportPrintService printService;
   @Autowired 
   FileService fileService;
    
    @Autowired
    MainEditorSettings set;
    
    @Value("${jsondox.url}")
    private String folder;
    

    public void whenFileLinkClicked() {
        
        setAllInvisible();
        controller.getFileEditorVBox().setVisible(true);
        
    }

    public void whenStationLinkClicked() {
         setAllInvisible();
        controller.getStationsEditorVBox().setVisible(true);
    }

    public void whenConsigneeLinkClicked() {
        setAllInvisible();
        controller.getConsigneeEditorVBox().setVisible(true);
    }
    
    public void whenTransportLinkClicked() {
       setAllInvisible();
        controller.getTransportEditorVBox().setVisible(true);
        
    }
    
    public void whenCargoLinkClicked() {
       setAllInvisible();
        controller.getCargoEditorVBox().setVisible(true);
    }

    public void whenPaymentsLinkClicked() {
       setAllInvisible();
        controller.getPaymentsEditorVBox().setVisible(true);
    }
    
    public void whenHomeButtonIsClicked() {
        homeController.getSearchTextField().textProperty().setValue("");
        homeController.setTable();
        homeController.getAppAnchorPane().getChildren().clear();
        homeController.getAppAnchorPane().getChildren().add(homeController.getTableVbox());
    }
    
    public void whenSaveButtonIsClicked() {
       
        CodesOrders co = codesOrdersProperties.getUpdatedCodesOrders();
        codesOrdersRepository.save(co);
        fileService.saveAsJson(co.getFileID(), co);
        printService.printThis(co.getFileID());
        
        whenHomeButtonIsClicked();
    }
    
    public void whenPrintButtonIsClicked() {
                
                 FileChooser fileChooser = new FileChooser();
                
                 Stage mainStage = new Stage();
                 
                 
//                 mainStage.initModality(Modality.APPLICATION_MODAL);
 fileChooser.setTitle("Open Resource File");
 fileChooser.getExtensionFilters().addAll(
         new ExtensionFilter("Text Files", "*.txt"),
         new ExtensionFilter("PDF", "*.pdf"),
         new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
         new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
         new ExtensionFilter("All Files", "*.*"));
 File selectedFile = fileChooser.showOpenDialog(mainStage);
 

 
 if (selectedFile != null) {
//     mainStage.show();
System.out.println(selectedFile);

                     try {
                         Desktop.getDesktop().open(selectedFile);
                     } catch (IOException ex) {
                         Logger.getLogger(MainEditorActions.class.getName()).log(Level.SEVERE, null, ex);
                     }


 }
        
    }
    private void setAllInvisible() {
       
        controller.getFileEditorVBox().setVisible(false);
        controller.getStationsEditorVBox().setVisible(false);
        controller.getConsigneeEditorVBox().setVisible(false);
        controller.getTransportEditorVBox().setVisible(false);
        controller.getCargoEditorVBox().setVisible(false);
        controller.getPaymentsEditorVBox().setVisible(false);
    }


    
}
