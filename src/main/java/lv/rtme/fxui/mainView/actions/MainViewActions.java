/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView.actions;

import java.util.List;
import lv.rtme.entities.Persons;
import lv.rtme.repositories.PersonsRepository;
import lv.rtme.services.ReadAndPopulate;
import org.controlsfx.control.action.ActionProxy;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Maksims
 */
public class MainViewActions {
     @Autowired
    ReadAndPopulate readerX;
      @Autowired
    private PersonsRepository personsRepository;

    public MainViewActions() {
    }
      
      
    
    @ActionProxy(text = "controls text",accelerator = "ctrl+shift+R")
   private void tableOnMouse() {
     }
   
    /* initial parsing of excell file       */
    @ActionProxy(text = "parse Excell",accelerator = "ctrl+shift+E")
   private void readExcell() {
       
          readerX.init();
        
          List<Persons> persons =   personsRepository.findAll();
        
     for (Persons person : persons) {
          if(person!=null){  
            String search = "";
            String sample = person.getSampleName();
            int l = sample.length();
            if(l>=30){l=30;};
            search = search.concat(sample.substring(0, l));
            
            person.setSearchName(search);
            personsRepository.save(person);
        }
     }
       
       
      
     }
   
   
    
}
