/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.railtransme.textToolControllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javax.annotation.PostConstruct;

/**
 *
 * @author User
 */
public class MainController implements Initializable {

    @FXML
    private TextField listSearchTextField;
    @FXML
    private ListView<?> listView;
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
      
        
    }
}
