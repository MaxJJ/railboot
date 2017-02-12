/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView.actions;

import lv.rtme.entities.CodesOrders;
import lv.rtme.fxui.controllers.MainEditorController;
import lv.rtme.fxui.controllers.RailbootMainController;
import lv.rtme.fxui.mainView.settings.MainEditorSettings;
import lv.rtme.fxui.models.CodesOrdersProperties;
import lv.rtme.services.ReportPrintService;
import lv.rtme.repositories.CodesOrdersRepository;
import lv.rtme.services.FileService;
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
        homeController.getAppAnchorPane().getChildren().clear();
        homeController.getAppAnchorPane().getChildren().add(homeController.getTableVbox());
    }
    
    public void whenSaveButtonIsClicked() {
       
        CodesOrders co = codesOrdersProperties.getUpdatedCodesOrders();
        codesOrdersRepository.save(co);
        fileService.saveAsJson(co.getFileID(), co);
        printService.printThis(co.getFileID());
        homeController.init();
        whenHomeButtonIsClicked();
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
