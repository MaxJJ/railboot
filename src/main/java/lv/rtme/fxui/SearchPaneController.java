/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.annotation.PostConstruct;
import lv.rtme.entities.CodesOrders;
import lv.rtme.repositories.CodesOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Maksims
 */
public class SearchPaneController {
    
    
     
     @Autowired private CodesOrdersRepository repository;
      // SEARCH BEGIN
       @FXML
    private Button searchButton;

    @FXML
    private TextField searchText;

    @FXML
    private ListView<String> searchResultList;
    
    @FXML
    private AnchorPane webAnchor;
    
    private WebEngine engine;
    
    // SEARCH END
    
      @FXML
    public void initialize() {
    }
    
    
    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        
                searchText.textProperty().addListener((oservable, oldValue, newValue) -> {
            searchResultList.getItems().clear();
            List<CodesOrders> que = repository.findByCargoLike("%" + newValue + "%");
            ObservableList<String> resList = FXCollections.observableArrayList();
            int i = 1;
            for (CodesOrders codesOrders : que) {

                resList.add(i + " ФАЙЛ " + codesOrders.getFileID() + "-----");
                resList.add(codesOrders.getCargo());
                i++;
            }
            searchResultList.setItems(resList);

        });
        
        
    }
    
    
    @FXML
 public void searchAction(){

     searchResultList.getItems().clear();
     List<CodesOrders> que = repository.findByCargoLike("%"+searchText.getText()+"%");
 ObservableList<String> resList = FXCollections.observableArrayList();
 String content = "<h1>BEGIN</h1><br/>";
     int i = 1;
         for (CodesOrders codesOrders : que) {
             
             resList.add(i+" ФАЙЛ "+codesOrders.getFileID()+ "-----" );
             resList.add(codesOrders.getCargo());
             content=content.concat("<p><b>"+codesOrders.getFileID()+"</b><span>  "+codesOrders.getProvider()+"  "+codesOrders.getRate()+codesOrders.getRateCurrency()+"</span></p>" );
           content=  content.concat("<p>"+codesOrders.getCargo()+"</p>");
            i++;
         }
          
           WebView webView = new WebView();
           webView.setStyle("font-size:12px");
           webView.setPrefWidth(300);
           webView.setMaxWidth(350);
           webView.getEngine().loadContent(content,"text/html");
           
       
         
          
       searchResultList.setItems(resList);
       
      
 }
    
}
