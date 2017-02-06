/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.models;

import java.text.Format;
import java.util.LinkedList;
import java.util.List;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.StringConverter;
import javax.annotation.PostConstruct;
import lombok.Getter;
import lv.rtme.entities.Persons;
import lv.rtme.entities.Station;
import lv.rtme.fxui.controllers.MainEditorController;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.Glyph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component
public class PageInfo {
    @Autowired
    CodesOrdersProperties coProps;
    @Autowired
    private MainEditorController controllerMainEditor; 
    
    private final Text fileId = new Text();
    private final Text descr = new Text();
    private final Text stDisp = new Text();
    private final Text stDest = new Text();
    private final Text consignee = new Text();
    private final Text container = new Text();
    private final Text wagon = new Text();
    private final Text cargo = new Text();
    private final Text provider = new Text();
    private final Text period = new Text();
    private final Text roads = new Text();
    private final Text rate = new Text();
    private final Text guardRate = new Text();
    private final Text weight = new Text();
    
   
    
    
   

    public PageInfo() {
       
         
    }
   
    public void init(){
        fileId.textProperty().bind(coProps.getFileIdProperty()); 
        descr.textProperty().bind(coProps.getCustomTagProperty());
        
        stDisp.textProperty().bindBidirectional(coProps.getStationOfDispatchProperty());
        stDest.textProperty().bindBidirectional(coProps.getStationOfDestinationProperty());
        consignee.textProperty().bindBidirectional(coProps.getConsigneeProperty());
        wagon.textProperty().bindBidirectional(coProps.getWagonProperty());
        container.textProperty().bindBidirectional(coProps.getUnitProperty());
        cargo.textProperty().bindBidirectional(coProps.getCargoProperty());
        provider.textProperty().bindBidirectional(coProps.getProviderProperty());
        weight.textProperty().bindBidirectional(coProps.getWeightProperty());
        rate.textProperty().bindBidirectional(coProps.getRateProperty());
        
    }  
     public List<Node> getFileText(){
        controllerMainEditor.getFileTextFlow().getChildren().clear();
         List<Node> list = new LinkedList();
         list.add(0, fileId);
        
         list.add(1, descr);
         return list;
     }       
     public List<Node> getStationsText(){
        controllerMainEditor.getStationsTextFlow().getChildren().clear();
         List<Node> list = new LinkedList();
         list.add(0, stDisp);
         list.add(1, new Text(" "));
         list.add(2, new Glyph("FontAwesome",FontAwesome.Glyph.ARROW_RIGHT));
         list.add(3, new Text(" "));
         list.add(4, stDest);
         return list;
     } 
     public List<Node> getShipperConsigneeText(){
        controllerMainEditor.getConsigneeTextFlow().getChildren().clear();
         List<Node> list = new LinkedList();
         list.add(0, consignee);
        
         return list;
     } 
     public List<Node> getTransportText(){
        controllerMainEditor.getTransportTextFlow().getChildren().clear();
         List<Node> list = new LinkedList();
         VBox box=new VBox();
         box.getChildren().add(wagon);
         box.getChildren().add(container);
         
         
         list.add(0, box);
        
         return list;
     } 
     public List<Node> getPaymentsText(){
        controllerMainEditor.getPaymentsTextFlow().getChildren().clear();
         List<Node> list = new LinkedList();
         VBox box=new VBox();
         box.getChildren().add(new TextFlow(provider,new Text(" "),roads));
         box.getChildren().add(new TextFlow(weight,new Text(" "),rate));
         
         
         list.add(0, box);
        
         return list;
     } 
     public List<Node> getCargoText(){
        controllerMainEditor.getCargoTextFlow().getChildren().clear();
         List<Node> list = new LinkedList();
         list.add(0, cargo);
        
         return list;
     } 
     
     
     
    public void fill() {
       controllerMainEditor.getFileTextFlow().getChildren().addAll(getFileText());
        controllerMainEditor.getStationsTextFlow().getChildren().addAll(getStationsText());
        controllerMainEditor.getConsigneeTextFlow().getChildren().addAll(getShipperConsigneeText());
        controllerMainEditor.getTransportTextFlow().getChildren().addAll(getTransportText());
        controllerMainEditor.getCargoTextFlow().getChildren().addAll(getCargoText());
        controllerMainEditor.getPaymentsTextFlow().getChildren().addAll(getPaymentsText());
    }
     
/*------------------------------------------------------------------------------*/
    private StringConverter<Station> stationStringConverter() {
       
        return new StringConverter<Station>() {
            @Override
            public String toString(Station object) {
                
                return object.getStationName();
            }

            @Override
            public Station fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }

    private StringConverter<Persons> personStringConverter() {
      
        return  new StringConverter<Persons>() {
            @Override
            public String toString(Persons object) {
               
                return object.getSampleName();
            }

            @Override
            public Persons fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }

    
}
