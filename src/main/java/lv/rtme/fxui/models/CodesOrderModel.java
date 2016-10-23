/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.models;

import lv.rtme.services.CodesTableItem;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */

@Component
public class CodesOrderModel {
    
    private String file;
    private String stDestination;
    private String stDispatch;
    private String consignee;
    
    
    
    public void init(CodesTableItem item){
        
      this.file= item.getFileID().getValue();
      this.stDispatch= item.getStationOfDispatch().getValue();
      this.stDestination= item.getStationOfDestination().getValue();
      this.consignee=item.getConsignee().getValue();
    }

    public String getFile() {
        return file;
    }

    public String getStDestination() {
        return stDestination;
    }

    public String getStDispatch() {
        return stDispatch;
    }

    public String getConsignee() {
        return consignee;
    }
    
    
    
}
