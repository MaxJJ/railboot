/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lv.rtme.entities.Station;
import lv.rtme.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */
@Component

public class UtilBeansCollection {
  @Autowired
 private StationRepository  stationRepository;
    
    
    @Bean(name = "stationsComboBox")
  @Scope("prototype")
        public ObservableList<String> strbean(){
                
        ObservableList<String> list = FXCollections.observableArrayList();
        List<Station> stringList = stationRepository.findAll();
        for (Station station : stringList) {
            list.add(station.getStationName());
        }
               return list;
    }
    
  
}
