/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView.settings;

import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.KeyCode;
import javafx.util.StringConverter;
import lv.rtme.entities.Persons;
import lv.rtme.fxui.controllers.MainEditorController;
import lv.rtme.fxui.models.CodesOrdersProperties;
import lv.rtme.repositories.CodesOrdersRepository;
import lv.rtme.repositories.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component
public class ConsigneeEditorSettings {

    @Autowired
    private MainEditorController controller;
    @Autowired
    CodesOrdersRepository codesOrdersRepository;
    @Autowired
    PersonsRepository personsRepository;

    @Autowired
    CodesOrdersProperties codesOrdersProperties;
    
    private Persons consignee;

    void editor() {

        controller.getConsigneeEditorTextArea().setEditable(true);
        controller.getConsigneeEditorListView().setCellFactory((val) -> {
            TextFieldListCell cell = new TextFieldListCell(new StringConverter<Persons>() {
                @Override
                public String toString(Persons object) {

                    return object.getSampleName();
                }

                @Override
                public Persons fromString(String string) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

            });

            return cell;
        });
        
        controller.getConsigneeEditorTextArea().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                List<Persons> list = personsRepository.findBySampleNameLikeIgnoreCase("%" + newValue + "%");
                controller.getConsigneeEditorListView().getItems().clear();
                controller.getConsigneeEditorListView().getItems().addAll(list);
            }
        });

        controller.getConsigneeEditorListView().setOnKeyPressed((keh) -> {

            if (keh.getCode() == KeyCode.ENTER) {
codesOrdersProperties.getConsigneeObjectProperty().setValue(controller.getConsigneeEditorListView().getSelectionModel().getSelectedItem());
                String value = controller.getConsigneeEditorListView().getSelectionModel().getSelectedItem().getSampleName();
                controller.getConsigneeEditorTextArea().setText(value);
            }
        });
    }
    
    
}
