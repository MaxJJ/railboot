/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.services;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import lv.rtme.entities.CodesOrders;
import lv.rtme.fxui.models.CodesOrderModel;
import lv.rtme.repositories.CodesOrdersRepository;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */
@Component
public class CodesTableService {
    @Autowired
    CodesOrdersRepository repository;
    @Autowired
    CodesOrderModel model;
    
    private List<CodesOrders> inList = new LinkedList<>();
    private ObservableList<CodesOrderModel> data = FXCollections.observableArrayList();



    public List<CodesOrders> getInList() {
        return inList;
    }

    public void setInList(List<CodesOrders> inList) {
        this.inList = inList;
    }

    public ObservableList<CodesOrderModel> getData() {
          for (CodesOrders codesOrders : inList) {
       model.init(codesOrders);
          data.add(model);
        }
          
        return data;
    }

    public void setData(ObservableList<CodesOrderModel> data) {
        this.data = data;
    }
    
    
}
