/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.services;

import java.util.LinkedList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lv.rtme.entities.CodesOrders;
import lv.rtme.fxui.models.CodesOrderModel;
import lv.rtme.repositories.CodesOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */
@Component
@Scope("prototype")
public class CodesTableService {
    @Autowired
    CodesOrdersRepository repository;
    
    @Qualifier("tableItem")
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
              CodesOrderModel modelx= new CodesOrderModel();
       modelx.init(codesOrders);
          data.add(modelx);
        }
          
        return data;
    }

    public void setData(ObservableList<CodesOrderModel> data) {
        this.data = data;
    }
    
    
}
