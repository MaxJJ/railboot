/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.repositories;

import java.util.List;
import lv.rtme.entities.Station;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author User
 */
public interface StationRepository extends CrudRepository<Station, Long> {
    
     List<Station> findAll();
     List<Station> findByStationName(String name);
    
}
