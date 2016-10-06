package lv.rtme;

import lv.rtme.entities.Points;
import lv.rtme.repositories.PointsRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RailbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RailbootApplication.class, args);
	}
        
        @Bean
        ApplicationRunner workit(PointsRepository repository){
          
            return  (args)->{
                
                repository.save(new Points("станция","Рига-Краста","123456"));
            };
            
        }
}
