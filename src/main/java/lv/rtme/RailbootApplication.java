package lv.rtme;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import lv.rtme.entities.Points;
import lv.rtme.entities.Station;
import lv.rtme.repositories.CodesOrdersRepository;
import lv.rtme.repositories.PointsRepository;
import lv.rtme.repositories.StationRepository;
import lv.rtme.services.XclReader;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RailbootApplication {
    
 @Autowired
 XclReader reader;
  
	public static void main(String[] args) {
		SpringApplication.run(RailbootApplication.class, args);
	}
        
        @Bean
        ApplicationRunner workit(PointsRepository repository,StationRepository stations, CodesOrdersRepository codes ){
          
            return  (args)->{
                
//                repository.save(new Points("станция","Рига-Краста","123456"));
             
            reader.readFromExcel();
            Set<String> set = reader.getSetFromColumn(2);
            
                for (String string : set) {
                   
                 Station newObj =  new Station();
                 newObj.setStationName(string);
                 
                 stations.save(newObj);
                }
                    
            
            };
            
        }
     
           
        }

