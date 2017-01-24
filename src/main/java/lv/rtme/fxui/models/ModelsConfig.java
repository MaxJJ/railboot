/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Maksims
 */
@Configuration
public class ModelsConfig {
    
    @Bean
    public CodesOrdersProperties getCOProps(){
        
        return new CodesOrdersProperties();
    }
    
    @Bean
    public TableItemsProperty getTableItems(){
        
       return new TableItemsProperty();
        
    }
}
