/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.services;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lv.rtme.entities.CodesOrders;
import lv.rtme.entities.Persons;
import lv.rtme.entities.Station;
import lv.rtme.repositories.CodesOrdersRepository;
import lv.rtme.repositories.PersonsRepository;
import lv.rtme.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */
@Component
public class ReadAndPopulate {
   @Autowired  private StationRepository stations;
   @Autowired  private XclReader reader;
   @Autowired private PersonsRepository persons; 
   @Autowired private CodesOrdersRepository codes;
   
   public void init(){
        readAndPopulateStation();
        readAndPopulatePersons();
        readAndPopulateCodesOrders();
    }
    
//       @Bean
//    @Order(1)        
    void readAndPopulateStation() {
      
            Set<String> set = reader.getSetFromColumn(2);
            set.addAll(reader.getSetFromColumn(1));

            for (String string : set) {
                Station newObj = new Station();
                newObj.setStationName(string);
                stations.save(newObj);
            }
      
    }
    
//    @Bean
//    @Order(100)        
    void readAndPopulatePersons() {
       
            Set<String> set = reader.getSetFromColumn(3);
int num = 0;
            for (String string : set) {
                String trim = string.trim();
                
                Persons newObj = new Persons();
                newObj.setSampleName(trim);
                num++;
//                int index = trim.indexOf("\n");
                 String search =null;
               try{ search = trim.substring(0, 12).replace(" ", "_").replace("\"", "_");}
               catch(StringIndexOutOfBoundsException e){
                  search = "blank";
               }
                newObj.setSearchName(search);
                persons.save(newObj);
            }
        
    }
    
//    @Bean
//    @Order(3000)
    void readAndPopulateCodesOrders(){
        
      
      
            for (int ix = 2; ix < 202; ix++) {
        Map<Integer,Object> myRow=null;        
       myRow =  reader.getRowAsMapBy(ix);
       CodesOrders table = new CodesOrders();
            for (int i = 0; i <= 13; i++) {
                Object item = myRow.get(i);
                
              switch(i) {
                  case 0:
                      table.setFileID((String) item);
                      break;
                  case 1:
                      List<Station> station = stations.findByStationName((String) item);
                      if(station.size()==0){break;}else{
                      table.setStationOfDispatch(station.get(0));
                      break;}
                  case 2:
                      List<Station> stationDest = stations.findByStationName((String) item);
                      if(stationDest.size()==0){break;}else{
                      table.setStationOfDestination(stationDest.get(0));
                      break;}
                  case 3:
                      String searchName = (String) item;
                       try{ searchName = searchName.substring(0,12).replace(" ", "_").replace("\"", "_");}
               catch(StringIndexOutOfBoundsException e){
                  searchName = "blank";
               }
                  
                      List<Persons> person = persons.findBySearchName(searchName);
                      
                      if(person.size()==0){break;}else{
                      table.setConsignee(person.get(0));
                     break; }
                      
                  case 4:
                      table.setCargo((String) item);
                      break;
                  case 5:
                      table.setWeight((String) item);
                      break;
                  case 6:
                      table.setWagon((String) item);
                      break;
                  case 7:
                      table.setProvider((String) item);
                      break;
                  case 8:
                      break;
                  case 9:
                      table.setRate((String) item);
                      break;
                  case 10:
                      table.setRateCurrency((String) item);
                      break;
                  case 11:
                      table.setRoadsToPay((String) item);
                      break;
                  case 12:
                      table.setUnit((String) item);
                      break;
                  case 13:
                      table.setOrderedOnDate((Date) item);
                      break;
               
              }
            }
   codes.save(table);
            
        }
  
    
   
     
           
        }
    
}
