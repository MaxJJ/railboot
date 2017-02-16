/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView.settings;

import javafx.scene.control.Button;
import lv.rtme.fxui.controllers.MainEditorController;
import lv.rtme.fxui.controllers.RailbootMainController;
import lv.rtme.fxui.mainView.actions.MainEditorActions;
import lv.rtme.fxui.models.CodesOrdersProperties;
import lv.rtme.fxui.models.TableItemsProperty;
import lv.rtme.repositories.CodesOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */
@Component
public class MainEditorSettings {

    @Autowired
    private MainEditorController controller;
    @Autowired
    RailbootMainController homeController;
   
    @Autowired
    CodesOrdersRepository codesOrdersRepository;
    
    @Autowired
    CodesOrdersProperties codesOrdersProperties;
    @Autowired
    TableItemsProperty tableItemsProperty;
    @Autowired
    MainEditorActions act;
    @Autowired
    StationsEditorSettings setStationsEditors;
    @Autowired
    FileEditorSettings setFileEditors;
    @Autowired
    ConsigneeEditorSettings setConsigneeEditors;
    @Autowired
    TransportEditorSettings setTransportEditors;
    @Autowired
    CargoEditorSettings setCargoEditors;
    @Autowired
    PaymentsEditorSettings setPaymentsEditors;

    public void buttons() {

        controller.getHomeButton().setOnAction((eh) -> {act.whenHomeButtonIsClicked(); });
        controller.getSaveButton().setOnAction((eh) -> {act.whenSaveButtonIsClicked(); });
        controller.getPrintButton().setOnAction((eh)-> {act.whenPrintButtonIsClicked();});

    }

    public void editorsFieldsBindings() {
       
        controller.getFileEditorFileIdTextField().textProperty().bindBidirectional(codesOrdersProperties.getFileIdProperty());
        controller.getFileEditorDescriptionTextArea().textProperty().bindBidirectional(codesOrdersProperties.getCustomTagProperty());
        controller.getStationsEditorStDispHLink().textProperty().bindBidirectional(codesOrdersProperties.getStationOfDispatchProperty());
        controller.getStationsEditorStDestHLink().textProperty().bindBidirectional(codesOrdersProperties.getStationOfDestinationProperty());
        controller.getConsigneeEditorTextArea().textProperty().bindBidirectional(codesOrdersProperties.getConsigneeProperty());
        controller.getTransportEditorWagonTextField().textProperty().bindBidirectional(codesOrdersProperties.getWagonProperty());
        controller.getTransportEditorContainerTextField().textProperty().bindBidirectional(codesOrdersProperties.getUnitProperty());
        controller.getTransportEditorIsContainerisedCheck().selectedProperty().bindBidirectional(codesOrdersProperties.getIsContainerisedProperty());
        controller.getCargoEditorTextArea().textProperty().bindBidirectional(codesOrdersProperties.getCargoProperty());
        controller.getPaymentsEditorAgentTextField().textProperty().bindBidirectional(codesOrdersProperties.getProviderProperty());
        controller.getPaymentsEditorCommentsTextArea().textProperty().bindBidirectional(codesOrdersProperties.getPaymentsCommentsProperty());
        controller.getPaymentsEditorPeriodTextField().textProperty().bindBidirectional(codesOrdersProperties.getPeriodProperty());
        controller.getPaymentsEditorRateTextField().textProperty().bindBidirectional(codesOrdersProperties.getRateProperty());
        controller.getPaymentsEditorWeightTextField().textProperty().bindBidirectional(codesOrdersProperties.getWeightProperty());
        controller.getPaymentsEditorRoadsTextField().textProperty().bindBidirectional(codesOrdersProperties.getRoadsToPayProperty());
        
    }

    public void navigation() {
       controller.getFileHLink().setOnAction((eh)->{act.whenFileLinkClicked();});
       controller.getStationsHLink().setOnAction((eh)->{act.whenStationLinkClicked();});
       controller.getConsigneeHLink().setOnAction((eh)->{act.whenConsigneeLinkClicked();});
       controller.getTransportHLink().setOnAction((eh)->{act.whenTransportLinkClicked();});
       controller.getCargoHLink().setOnAction((eh)->{act.whenCargoLinkClicked();});
       controller.getPaymentsHLink().setOnAction((eh)->{act.whenPaymentsLinkClicked();});
        
    }

    public void editors() {
  
     setStationsEditors.editor();
     setConsigneeEditors.editor();
     setTransportEditors.editor();
     setCargoEditors.editor();
     setPaymentsEditors.editor();
     
    }

    
}
