/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui;

import lv.rtme.ConfigurationControllers;
import lv.rtme.fxui.mainView.ApplicationViewsAndControllers;
import lv.rtme.fxui.mainView.RailbootMainController;
import lv.rtme.fxui.models.CodesOrderModel;
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
    private ApplicationViewsAndControllers.View homeView;

    @Qualifier("railbootMainView")
    @Autowired
    private ConfigurationControllers.View mainView;

    @Qualifier("coModel")
    @Autowired
    private CodesOrderModel model;

    @Autowired
    PersonsRepository personsRepository;
    @Autowired
    StationRepository stationRepository;
    @Autowired
    UtilBeansCollection utils;

    
    private RailbootMainController getMainController() {

        return (RailbootMainController) mainView.getController();
    }
    
    

    public CodesOrderModel getCodesOrderModel() {
        return model;
    }
    




}
