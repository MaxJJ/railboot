/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.repositories;

import lv.rtme.entities.Points;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Maksims
 */
public interface PointsRepository extends CrudRepository<Points, Long> {
    
    
    
}
