/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui;

import java.util.List;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.layout.StackPane;
import lv.rtme.ConfigurationControllers;
import lv.rtme.entities.Persons;
import lv.rtme.entities.Station;
import lv.rtme.fxui.mainView.MainViewControllers;
import lv.rtme.fxui.mainView.RailbootMainController;
import lv.rtme.fxui.models.CodesOrderModel;
import lv.rtme.fxui.rightEditor.RightEditorController;
import lv.rtme.repositories.PersonsRepository;
import lv.rtme.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */

@Component
public class MainViewUtils {

    @Qualifier("homeView")
    @Autowired
    private MainViewControllers.View homeView;

    @Qualifier("railbootMainView")
    @Autowired
    private ConfigurationControllers.View mainView;
    @Qualifier("rightEditor")
    @Autowired
    private ConfigurationControllers.View coEditorView;

    @Qualifier("coModel")
    @Autowired
    private CodesOrderModel model;

    @Autowired
    PersonsRepository personsRepository;
    @Autowired
    StationRepository stationRepository;
    @Autowired
    UtilBeansCollection utils;

    private RightEditorController getRightEditorController() {
        return (RightEditorController) coEditorView.getController();
    }
    private void selectHomeTab() {
        Tab homeTab = getMainController().getHomeTab();
        getMainController().getHomeTabPane().getSelectionModel().select(homeTab);
        homeTab.setText("Начало");
    }
    
    private void setHomeTabStartView() {
        getMainController().getHomeTabStackPane().getChildren().clear();
        getMainController().getHomeTabStackPane().getChildren().addAll(homeView.getView());
    }
    private RailbootMainController getMainController() {

        return (RailbootMainController) mainView.getController();
    }
    
    
    /** setting start view  -- show Home View , clear Model  */
    public void showHomeTab() {
        selectHomeTab();
        setHomeTabStartView();
    }

    public CodesOrderModel getCodesOrderModel() {
        return model;
    }
    
    public StackPane returnHomeTabStackPane() {
        return getMainController().getHomeTabStackPane();
    }

    public Parent getCoEditorView() {
        return coEditorView.getView();
    }

    public Tab returnHomeTab() {
        return getMainController().getHomeTab();
    }

    /* adds items to all combos */
    public void setCombosItems() {
        RightEditorController rec = getRightEditorController();
        List<Persons> pl = personsRepository.findAllByOrderBySearchNameAsc();
        List<Station> sl = stationRepository.findAllByOrderByStationNameAsc();
        rec.getConsiNameCombo().getItems().addAll(pl);
        rec.getStDestCombo().getItems().clear();
        rec.getStDispCombo().getItems().clear();
        rec.getStDestCombo().getItems().addAll(sl);
        rec.getStDispCombo().getItems().addAll(sl);

    }

}
