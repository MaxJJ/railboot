/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.railtransme.textToolControllers;

import com.railtransme.entities.MyTool;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import com.railtransme.repositories.MyToolRepository;


/**
 *
 * @author User
 */
public class MainController implements Initializable {
@Autowired
private MyToolRepository repo;
    @FXML
    private TextField listSearchTextField;
    @FXML
    private ListView<MyTool> listView;
    @FXML
    private Button newSaveButton;
    @FXML
    private Button newCancelButton;
    @FXML
    private TextField newTextField;
    @FXML
    private TextArea newTextArea;
    @FXML
    private Button editorSaveButton;
    @FXML
    private Button editorDeleteButton;
    @FXML
    private TextField editorTextField;
    @FXML
    private TextArea editorTextArea;
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
        
    }  
    
    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init(){
      
         setNewSaveButton();
        listView.itemsProperty().setValue(FXCollections.observableArrayList(repo.findAll()));
        listView.itemsProperty().addListener(new ChangeListener<ObservableList<MyTool>>() {
           @Override
           public void changed(ObservableValue<? extends ObservableList<MyTool>> ov, ObservableList<MyTool> t, ObservableList<MyTool> t1) {
           listView.getItems().clear();
           listView.setItems(t1);
           }
       }); 
    }

    private void setNewSaveButton() {
        
        newSaveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                
                MyTool mytool = new MyTool();
                
                mytool.setTag(newTextField.getText());
                mytool.setItem(newTextArea.getText());
                
                repo.save(mytool);
                listView.itemsProperty().getValue().add(mytool);
            }
        });
    }
}
