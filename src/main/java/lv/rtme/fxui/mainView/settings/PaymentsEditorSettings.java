/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView.settings;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import lv.rtme.fxui.controllers.MainEditorController;
import lv.rtme.fxui.models.CodesOrdersProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component
public class PaymentsEditorSettings {
   
     @Autowired
    private MainEditorController controller;
      @Autowired
    CodesOrdersProperties codesOrdersProperties;
    
    public void editor() {
        
        controller.getPaymentsEditorRequestTitledPane().expandedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
               
                if(newValue){
                    LocalDateTime datetime = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd'/'MM'  'k':'m");
                    
                  controller.getPaymentsEditorRequestTitledPane().textProperty().setValue("Запрошено : "+datetime.format(formatter));
                  controller.getPaymentsEditorRequestTextArea().textProperty().setValue(rateRequestText());
                }
            }

            private String rateRequestText() {
              String text = "";
              String first = "Просим предоставить ставку на жд перевозку в период "+codesOrdersProperties.getPeriodProperty().getValueSafe()+"\n";
              String second = "За участки : "+codesOrdersProperties.getRoadsToPayProperty().getValueSafe()+"\n";
              String third = "Станция назначения : "+ codesOrdersProperties.getStationOfDestinationProperty().getValueSafe()+"\n";
              String fourth =  codesOrdersProperties.getUnitProperty().getValueSafe()+" / " + codesOrdersProperties.getWagonProperty().getValueSafe()+"\n";
              String fifth =  "Вес : "+ codesOrdersProperties.getWeightProperty().getValueSafe()+"\n";
              String sixth =  "Груз: "+"\n"+ codesOrdersProperties.getCargoProperty().getValueSafe()+"\n";
              String seventh =  codesOrdersProperties.getPaymentsCommentsProperty().getValueSafe();
              
              text=text.concat(first).concat(second).concat(third).concat(fourth).concat(fifth).concat(sixth).concat(seventh);
              
                return text;
            }
        });
        
    }
    

}
