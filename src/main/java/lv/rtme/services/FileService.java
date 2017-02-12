/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lv.rtme.fxui.mainView.actions.MainEditorActions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */
@Component
public class FileService {
    @Value("${jsondox.url}")
    private String folder;
    
    public void saveAsJson(String name,Object item){
                  ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(folder+"\\"+name+".json"), item);
        } catch (IOException ex) {
            Logger.getLogger(MainEditorActions.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
    }
    
    public String getPath(String resource){
        
     return getClass().getClassLoader().getResource(resource).getPath();
    }
}
