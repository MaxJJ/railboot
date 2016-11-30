/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.repositories;

import java.util.List;
import lv.rtme.entities.CodesOrders;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author User
 */
public interface CodesOrdersRepository extends CrudRepository<CodesOrders, Long> {
    
    List<CodesOrders> findAll();
    
    List<CodesOrders> findByCargoLike(String search);
    List<CodesOrders> findBySearchStringLikeIgnoreCase(String search);
    
}
