/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.stationsEditorView;

import javafx.scene.control.ListCell;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import lv.rtme.entities.Station;

/**
 *
 * @author Maksims
 */
public class StationListCell extends ListCell<Station>{

       
   @Override
   protected void updateItem(Station item, boolean empty){
       
       super.updateItem(item, empty);
       setText(null);
       setGraphic(null);
       
       if(item!=null){
           TextFlow textFlow = new TextFlow();
           textFlow.autosize();
           Text name = new Text(item.getStationName()+" "+item.getStationCode()+" "+item.getStationRoad()+"\n");
           Text paragr = new Text("параграфы: "+item.getStationParagraph());
           name.autosize();
           textFlow.getChildren().addAll(name,paragr);
           super.setGraphic(textFlow);
       }
       
   };
    
    
}
