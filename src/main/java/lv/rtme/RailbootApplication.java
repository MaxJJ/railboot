package lv.rtme;

import java.util.Set;
import lv.rtme.entities.Station;
import lv.rtme.repositories.PersonsRepository;
import lv.rtme.repositories.StationRepository;
import lv.rtme.services.XclReader;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RailbootApplication {
    
// @Autowired
// XclReader reader;
  
	public static void main(String[] args) {
		SpringApplication.run(RailbootApplication.class, args);
	}
        
    @Bean
    ApplicationRunner workit(StationRepository statins, PersonsRepository persons,XclReader reader) {
        return (args) -> {
            System.out.println("-----------------"+reader.toString());
//            reader.readFromExcel();
            Set<String> set = reader.getSetFromColumn(2);
            
//            set.addAll(reader.getSetFromColumn(1));
            
            
            for (String string : set) {
                Station newObj = new Station();
                newObj.setStationName(string);
                statins.save(newObj);
            }
        };

    }
     
           
        }

