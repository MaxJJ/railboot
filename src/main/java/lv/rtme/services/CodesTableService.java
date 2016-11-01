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
import lv.rtme.repositories.CodesOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */
@Component
public class CodesTableService {
   @Autowired CodesOrdersRepository repository;
 private List<CodesOrders> inList = new LinkedList<>();
    private ObservableList<CodesTableItem> data = FXCollections.observableArrayList();
    
    

    public List<CodesOrders> getInList() {
        return inList;
    }

    public void setInList(List<CodesOrders> inList) {
        this.inList = inList;
    }

    public ObservableList<CodesTableItem> getData() {
          for (CodesOrders codesOrders : inList) {
            CodesTableItem item = new CodesTableItem();
          item.getFileIdProperty().setValue(codesOrders.getFileID());
          item.getStationOfDispatchProperty().setValue(codesOrders.getStationOfDispatch().getStationName());
          item.getStationOfDestinationProperty().setValue(codesOrders.getStationOfDestination().getStationName());
           item.getCargoProperty().setValue(codesOrders.getCargo());
           item.getWagonProperty().setValue(codesOrders.getWagon());
           item.getUnitProperty().setValue(codesOrders.getUnit());
           item.getRateProperty().setValue(codesOrders.getRate()+" "+codesOrders.getRateCurrency());
           item.getConsigneeProperty().setValue(codesOrders.getConsignee().getSampleName());
           item.getCodesOrdersProperty().setValue(codesOrders);
           
          
          data.add(item);
        }
          
        return data;
    }

    public void setData(ObservableList<CodesTableItem> data) {
        this.data = data;
    }
    
    
}
