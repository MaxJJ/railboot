/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.repositories;

import org.springframework.data.repository.CrudRepository;
import lv.rtme.entities.CodesOrders;

/**
 *
 * @author User
 */
public interface CodesOrdersRepository extends CrudRepository<CodesOrders, Long> {
    
}
