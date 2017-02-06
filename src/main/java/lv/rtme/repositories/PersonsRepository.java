/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.repositories;

import java.util.List;
import lv.rtme.entities.Persons;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Maksims
 */
public interface PersonsRepository extends CrudRepository<Persons, Long> {
    List<Persons> findAll();
    List<Persons> findAllByOrderBySearchNameAsc();
    
    List<Persons> findBySampleNameLikeIgnoreCase(String name);
    List<Persons> findBySearchName(String searchname);
    
}
