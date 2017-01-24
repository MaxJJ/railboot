/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.models;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;
import lv.rtme.entities.CodesOrders;

/**
 *
 * @author User
 */
public class TableItemsProperty {
  @Getter  
  private final  ObjectProperty<ObservableList<CodesOrdersProperties>> itemsProperty = new SimpleObjectProperty();
  @Getter
  private final  ObjectProperty<List<CodesOrders>> coListProperty = new SimpleObjectProperty();
//  private final List<CodesOrders> ini;
   
  public TableItemsProperty() {
      
      itemsProperty.setValue(FXCollections.observableArrayList());
//      coListProperty.setValue(ini);
      addCoListListener();
    }
    
   public void setInList(List<CodesOrders> inList){
     
       coListProperty.setValue(inList);
   } 

    private void addCoListListener() {
       
        coListProperty.addListener(new ChangeListener<List<CodesOrders>>() {
            @Override
            public void changed(ObservableValue<? extends List<CodesOrders>> ov, List<CodesOrders> t, List<CodesOrders> t1) {
                System.out.println("old list co-----"+t);
                System.out.println("new list co-----"+t1);
//                if(t!=null){ itemsProperty.getValue().clear();}
                
                for (CodesOrders codesOrders : t1) {
                   
                    itemsProperty.getValue().add(new CodesOrdersProperties(codesOrders) );
                }
                
                
            }
        });
    }
}
