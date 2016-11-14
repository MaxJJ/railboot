/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui;

import java.util.List;
import java.util.StringTokenizer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.annotation.PostConstruct;
import lv.rtme.entities.CodesOrders;
import lv.rtme.entities.Station;
import lv.rtme.repositories.CodesOrdersRepository;
import lv.rtme.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */
@Component

public class UtilBeansCollection {
  @Autowired
 private StationRepository  stationRepository;
  @Autowired
  private CodesOrdersRepository codesOrdersRepository;
    
    
        public ObservableList<Station> strbean(){
                
        ObservableList<Station> list = FXCollections.observableArrayList();
        List<Station> stringList = stationRepository.findAll();
        list.addAll(stringList);
//        for (Station station : stringList) {
//            list.add(station);
//        }
               return list;
    }
        
        @PostConstruct
         public void setSearch(){
           
            List<CodesOrders> list = codesOrdersRepository.findAll();
            String search="";
            for (CodesOrders codesOrders : list) {
              search = search.concat(codesOrders.getFileID().concat(codesOrders.getProvider()));
              
              
              String cargo = codesOrders.getCargo();
              
                StringTokenizer cargoTok = new StringTokenizer(cargo);
                
                while (cargoTok.hasMoreElements()) {
                    String nextElement = (String) cargoTok.nextElement();
                    if(nextElement.length()>4){
                        
                        search=search.concat(nextElement);
                    }
                    
                }
              
              
              codesOrders.setSearchString(search);
              
                codesOrdersRepository.save(codesOrders);
                
                
                
                search="";
            }
        }
    
  
}
