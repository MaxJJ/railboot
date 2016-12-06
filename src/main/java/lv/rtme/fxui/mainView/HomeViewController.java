/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.mainView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javax.annotation.PostConstruct;
import lv.rtme.entities.CodesOrders;
import lv.rtme.entities.Persons;
import lv.rtme.fxui.MainViewUtils;
import lv.rtme.repositories.CodesOrdersRepository;
import lv.rtme.repositories.PersonsRepository;
import lv.rtme.services.ReadAndPopulate;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.Glyph;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * FXML Controller class
 *
 * @author Maksims
 */
public class HomeViewController implements Initializable {

    @FXML
    private Button readButton;
    @FXML
    private Button readButton1;
    @FXML
    private Button homeShowAllButton;
    @FXML
    private Button readButton111;
    @FXML
    private Button readButton1111;
    @FXML
    private Button readButton11111;
    @FXML
    private Button homeNotOrderedButton;
    @FXML
    private Button homeNewButton;
    @FXML
    private Button readButton11111111;
    
      /*---------AUTOWIRED---------*/
    
    @Autowired
    ReadAndPopulate readerX;
      @Autowired
    private PersonsRepository personsRepository;
     @Autowired
    private CodesOrdersRepository codesOrdersRepository;
      @Autowired
    MainViewUtils mvu;
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init(){
        setButtonsPropsAndActions();
        readFromExcell();
        readButton.setGraphic(new Glyph("FontAwesome", FontAwesome.Glyph.EDIT));
        
    }
           /* reading from excell  */
    private void readFromExcell() {
         readButton.setOnAction((ActionEvent event) -> {
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
             setSearch();
             
           
             mvu.setCombosItems();
             readButton.setDisable(true);
             
         });
    }
     /* setting setting SearchString field in @link CodesOrder */
    private void setSearch() {
        List<CodesOrders> list = codesOrdersRepository.findAll();
        String search = "";
        for (CodesOrders codesOrders : list) {
            search = search.concat(codesOrders.getFileID().concat(codesOrders.getProvider()));
            String cargo = codesOrders.getCargo();
            StringTokenizer cargoTok = new StringTokenizer(cargo);
            while (cargoTok.hasMoreElements()) {
                String nextElement = (String) cargoTok.nextElement();
                if (nextElement.length() > 4) {
                    search = search.concat(nextElement);
                }
            }
            
            search = search.concat(codesOrders.getConsignee().getSampleName()).concat(codesOrders.getStationOfDestination().getStationName());
            codesOrders.setSearchString(search);
            codesOrdersRepository.save(codesOrders);
            search = "";
        }
    }


    private void setButtonsPropsAndActions() {
        setHomeNewButton();
         
    }

    private void setHomeNewButton() {
        homeNewButton.setOnAction(event ->{
         mvu.showHomeTab();
         CodesOrders newCo= new CodesOrders();
         
         mvu.getCodesOrderModel().init(newCo);
         mvu.returnHomeTabStackPane().getChildren().clear();
         Parent coEditorView = mvu.getCoEditorView();
         mvu.returnHomeTabStackPane().getChildren().addAll(coEditorView);
         mvu.returnHomeTab().setText("Новый");
            
        });
    }
    
}
